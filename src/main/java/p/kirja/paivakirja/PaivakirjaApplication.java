package p.kirja.paivakirja;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import p.kirja.paivakirja.domain.Type;
import p.kirja.paivakirja.domain.TypeRepo;
import p.kirja.paivakirja.domain.Wine;
import p.kirja.paivakirja.domain.WineRepo;




@SpringBootApplication
public class PaivakirjaApplication {
	private static final Logger log = LoggerFactory.getLogger(PaivakirjaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PaivakirjaApplication.class, args);
	}

	@Bean
	public CommandLineRunner paivaKirja(WineRepo wirepo, TypeRepo tyrepo) {
		return (args) -> {
			log.info("esimerkkiviinit");

				tyrepo.save(new Type("Punaviini"));
				tyrepo.save(new Type("Valkoviini"));
				tyrepo.save(new Type("Oranssiviini"));
				tyrepo.save(new Type("Rosee"));
				tyrepo.save(new Type("Väkevöity viini"));
				tyrepo.save(new Type("Kuohuviini"));				
				
				
				wirepo.save(new Wine("Alves de Sousa", "Abandonado", "2011", "DOC Douro", "Douro", "Portugal", "Touriga Nacional, Touriga Franca", tyrepo.findByName("Punaviini").get(0), "Muhkea ja voimakas. Hieno yhdistelmä grillatun pihvin kanssa", "93"));
				wirepo.save(new Wine("R. Lopez de Heredia", "Vina Tondonia", "1995", " DOCa Rioja Gran Reserva", "Rioja", "Spain", "Tempranillo", tyrepo.findByName("Punaviini").get(0), "Elegantti ja viettelevä. Meditointiviini", "97"));
				wirepo.save(new Wine("Domaine Georges Vernay", "Terrasses de l'Empire", "2019", "AC Condrieu", "Rhone", "France", "Viognier", tyrepo.findByName("Valkoviini").get(0), "Vielä turhan nuori. 10 vuoden kellaroinnin kautta mineraalisuus nousee.", "91"));
				wirepo.save(new Wine("La Stoppa", "Ageno", "2011", "IGT Emilia-Romagna", "Emilia-Romagna", "Italy", "Malvasia", tyrepo.findByName("Oranssiviini").get(0), "Melko erikoinen. Jälkimaku kuin sahanpurua", "85"));
				wirepo.save(new Wine("Domaine Schoffit", "Cuvee Catherine Lieu-dit Harth", "2000", "AC Alsace", "Alsace", "France", "Riesling", tyrepo.findByName("Valkoviini").get(0), "Hyvin kypsä. Paljon makeaa omenaisuutta.", "89"));
				wirepo.save(new Wine("Bollinger", "La Grande Annee", "1988", "AC Champagne", "Champagne", "France", "Pinot Noir, Chardonnay, Pinot Meunier", tyrepo.findByName("Kuohuviini").get(0), "Paras samppanja, jota olen koskaan juonut.", "100"));
				wirepo.save(new Wine("Weingut Gessinger", "Zeltinger Sonnenuhr Caldo Infernale", "2010", "Prädikatswein Mosel Auslese", "Mosel-Saar-Ruwer", "Germany", "Riesling", tyrepo.findByName("Valkoviini").get(0), "Kovin on hapanta", "75"));
				wirepo.save(new Wine("Jurtschitsch", "Steinhaus", "2007", "DAC Kamptal", "Niederösterreich", "Austria", "Gruner Veltliner", tyrepo.findByName("Valkoviini").get(0), "Paljon aprikoosia ja kypsää omenaa. RIsotolle sopiva", "84"));

				
				
				log.info("fetch all wines");
				for (Wine wine : wirepo.findAll()) {
						log.info(wine.toString());
				}
		};
	}
}
	