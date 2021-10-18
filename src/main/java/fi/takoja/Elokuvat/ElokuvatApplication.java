package fi.takoja.Elokuvat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElokuvatApplication {

	private static final Logger log = LoggerFactory.getLogger(ElokuvatApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ElokuvatApplication.class, args);
	}

	// remmaa tästä...
//	@Bean
//	public CommandLineRunner elokuvaListaus(ElokuvaRepository erepository, KategoriaRepository krepository, FormaattiRepository frepository) {
//		return (args) -> {
//			log.info("Tallennetaan pari elokuvaa");
//			
//			krepository.save(new Kategoria("Jännitys"));
//			krepository.save(new Kategoria("Draama"));
//			krepository.save(new Kategoria("Historia"));
//			
//			frepository.save(new Formaatti("BD"));
//			frepository.save(new Formaatti("DVD"));
//			frepository.save(new Formaatti("BD + DVD"));
//			
//			erepository.save(new Elokuva("Peräkylän parhaat", "Pertti Peräkylä", krepository.findByKategorianimi("Draama").get(0), "http://takoja.fi/", 1990, frepository.findByFormaattinimi("BD").get(0)));
//			erepository.save(new Elokuva("Kouvolan kauniit", "Kati Kotioja", krepository.findByKategorianimi("Draama").get(0), "http://takoja.fi/", 2001, frepository.findByFormaattinimi("BD").get(0)));
//			erepository.save(new Elokuva("Latteat laaksot", "Lassi Leppälä", krepository.findByKategorianimi("Jännitys").get(0), "http://takoja.fi/", 2011, frepository.findByFormaattinimi("DVD").get(0)));
//			erepository.save(new Elokuva("Nagrandin nähtävyydet", "Hemet Nesingwary", krepository.findByKategorianimi("Historia").get(0), "http://takoja.fi/", 2006, frepository.findByFormaattinimi("BD + DVD").get(0)));
//		
//			log.info("Listataan kaikki elokuvat");
//			for (Elokuva elokuva : erepository.findAll()) {
//				log.info(elokuva.toString());
//			}
//		};
//	}

	// ... tänne asti
	
}
