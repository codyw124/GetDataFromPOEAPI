package hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	ResponseRepository responseRepository;
	@Autowired
	StashRepository stashRepository;
	@Autowired
	ItemRepository itemRepository;

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			//TODO
			//get the last change id
			String nextChangeId = "";
			int x = 1;
			do{
				Response r = restTemplate.getForObject(
						"http://api.pathofexile.com/public-stash-tabs?id=" + nextChangeId, Response.class);

				nextChangeId = r.getNextChangeId();

				responseRepository.save(r);

				for(Stash s : r.getStashes()){

					if(x == 112){
						log.info("starting to find items");
					}
					x++;
					for(Item i : s.getItems()){
						itemRepository.save(i);
						log.info( "item saved");
					}
				}

			} while(!nextChangeId.equals(""));
		};
	}
}