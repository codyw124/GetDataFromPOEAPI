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
			int x = 0;
			do{
				Response r = restTemplate.getForObject(
						"http://api.pathofexile.com/public-stash-tabs?id=" + nextChangeId, Response.class);

				nextChangeId = r.getNextChangeId();

				responseRepository.save(r);

				for(Stash s : r.getStashes()){
					for(Item i : s.getItems()){

						i.setAccountName(s.getAccountName());

						int totalResistances = 0;

						if(i.getExplicitMods() != null && !i.getTypeLine().toUpperCase().contains("ESSENCE")){
							for(String property : i.getExplicitMods()){
								totalResistances += getPropertyResistances(property);
							}
						}

						i.setTotalResistances(totalResistances);

						itemRepository.save(i);
						log.info( "item " + x + " saved");

						x++;
					}
				}

			} while(!nextChangeId.equals(""));
		};
	}

	private int getNumber(String stringWithNumber){

		StringBuilder charsThatAreNumbers = new StringBuilder();

		charsThatAreNumbers.append("0");

		for(char x : stringWithNumber.toCharArray()){
			
			if(Character.isDigit(x)){
				charsThatAreNumbers.append(x);
			}
		}
		
		return Integer.valueOf(charsThatAreNumbers.toString());
	}

	private int getPropertyResistances(String property){
		int ret = 0;

		property = property.toUpperCase();

		if(property.endsWith("TO FIRE AND LIGHTNING RESISTANCES") ||
		property.endsWith("TO FIRE AND COLD RESISTANCES") ||
		property.endsWith("TO COLD AND LIGHTNING RESISTANCES")){
			ret = getNumber(property) * 2;
		}
		else if(property.endsWith("TO ALL ELEMENTAL RESISTANCES")){
			ret = getNumber(property) * 3;
		}
		else if(property.endsWith("TO FIRE RESISTANCE") ||
		property.endsWith("TO COLD RESISTANCE") ||
		property.endsWith("TO LIGHTNING RESISTANCE")){
			ret = getNumber(property);
		}

		return ret;
	}

	int getPlayerLife(int level, int strength, int percentIncreased, int addedLife){
		int health = (38 + (12 * level) + (strength / 2) + addedLife) * (1);
	


		return health;
	}
}