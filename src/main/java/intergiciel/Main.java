package intergiciel;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import intergiciel.consumer.ConsumerCustom1;
import intergiciel.producer.un.ProducerCustom1;
import intergiciel.services.Creator;

//@SpringBootApplication
public class Main {

	static final String KEY = "request";

	static final String TOPIC = "topic2";

	static public KafkaProducer<String, String> KafkaProducer2;

	static public void createProduceur() {
		Properties kafkaProps2 = new Properties(); // (1)

		kafkaProps2.put("bootstrap.servers", "localhost:9092"); // (2)
		kafkaProps2.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		kafkaProps2.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		try {
			KafkaProducer2 = new KafkaProducer<String, String>(kafkaProps2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static String menu() {
		return "Get_global_values (retourne les valeurs globales clés Global du fichier json)\r\n"
				+ "Get_country_values v_pays (retourne les valeurs du pays demandé ou v_pays est une chaine de caractère du pays demandé)\r\n"
				+ "Get_confirmed_avg (retourne une moyenne des cas confirmés sum(pays)/nb(pays))\r\n"
				+ "Get_deaths_avg (retourne une moyenne des Décès sum(pays)/nb(pays))\r\n"
				+ "Get_countries_deaths_percent (retourne le pourcentage de Décès par rapport aux cas confirmés)\r\n"
				+ "Help (affiche la liste des commandes et une explication comme ci-dessus)\n"
				+ "Exit (quitter le programme";
	}

	public static void main(String[] args) throws InterruptedException {

		// SpringApplication.run(Main.class, args);

		createProduceur(); // produceur 2

		Creator.createProduceur(); // produceur 3

		// ProducerCustom1.produceurRun(); // produceur 1

		Creator.consumerDeux(); // Consumer 2

		Creator.consumerTrois(); // Consumer 3

		// ConsumerCustom1.consumeurRun(); // Consumer 1

		Scanner sc = new Scanner(System.in);

		boolean exit = false;

		while (exit != true) {

			System.out.println(menu());

			String value = sc.next();

			switch (value) {
			case "Get_global_values":
				Creator.produceur(KEY, value, KafkaProducer2, TOPIC);
				break;
			case "Get_confirmed_avg":
				break;
			case "Get_deaths_avg":
				break;
			case "Get_countries_deaths_percent":
				break;
			case "Help":
				System.out.println(menu());
				break;
			case "Exit":
				exit = true;
				break;
			case "test":
				break;
			default:
				System.out.println("Choix Inconue");
				break;
			}

		}

		sc.close();
	}

}
