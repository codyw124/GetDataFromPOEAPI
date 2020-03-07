package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAsync
public class AccessingDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private String nextChangeId = "";
	private HttpHeaders headers = new HttpHeaders();
	private HttpEntity<String> entity;
	private long totalStashTabs = 0;

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate, StashPageRepository stashPageRepository) {
		return args -> {

			totalStashTabs = stashPageRepository.count();
			if (totalStashTabs > 0) {
				StashPage lastOneSaved = ((List<StashPage>) stashPageRepository
						.findAll(Sort.by("processDate").descending())).get(0);
				nextChangeId = lastOneSaved.getNextChangeId();
			}

			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			entity = new HttpEntity<String>("parameters", headers);

			while (true) {
				try {
					ResponseEntity<StashPage> response = restTemplate.exchange(
							"http://api.pathofexile.com/public-stash-tabs/" + nextChangeId, HttpMethod.GET, entity,
							StashPage.class);

					StashPage stashPage = response.getBody();

					stashPage.setMyChangeId(nextChangeId);

					stashPage.setProcessDate(new java.util.Date());

					stashPageRepository.save(stashPage);

					System.out.println(String.valueOf(++totalStashTabs) + '\t' + nextChangeId);

					nextChangeId = stashPage.getNextChangeId();
				} catch (Exception e) {
					System.out.println("Exception was thrown trying again");
				}
			}
		};
	}
}