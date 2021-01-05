package intergiciel.services;

import intergiciel.services.CommandesImpl;

import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * 
 * @author Stephane
 *
 */
public class Creator {

	static CommandesImpl commandes = new CommandesImpl();

	static public KafkaProducer<String, String> KafkaProducer3;

	static public void createProduceur() {

		Properties kafkaProps3 = new Properties(); // (1)

		kafkaProps3.put("bootstrap.servers", "localhost:9092"); // (2)
		kafkaProps3.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		kafkaProps3.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		try {
			KafkaProducer3 = new KafkaProducer<String, String>(kafkaProps3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void consumerDeux() {

		Thread t = new Thread() {
			public void run() {
				Properties props = new Properties();

				String value = "";
				String key = "response";
				String topicSend = "topic3";
				String topicSub = "topic2";

				props.put("bootstrap.servers", "localhost:9092");
				props.put("group.id", "test");
				props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
				props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

				try (Consumer<String, String> consumer = new KafkaConsumer<String, String>(props)) {
					consumer.subscribe(Collections.singletonList(topicSub));
					try {
						while (true) {
							ConsumerRecords<String, String> records = consumer.poll(100);
							for (ConsumerRecord<String, String> record : records) {
								switch (record.value()) {
								case "Get_global_values":
									System.out.println("DEBUG: ");
									value = commandes.getGlobalValues();
									produceur(key, value, KafkaProducer3, topicSend);
									break;
								case "Get_confirmed_avg":
									value = commandes.getGlobalValues();
									produceur(key, value, KafkaProducer3, topicSend);
									break;
								case "Get_deaths_avg":
									value = commandes.getGlobalValues();
									produceur(key, value, KafkaProducer3, topicSend);
									break;
								case "Get_countries_deaths_percent":
									value = commandes.getGlobalValues();
									produceur(key, value, KafkaProducer3, topicSend);
									break;
								default:
									break;
								}
							}
						}
					} finally {
						consumer.close();
					}

				}
			}
		};
		t.start();

	}

	public static void consumerTrois() {

		Thread t = new Thread() {
			public void run() {
				Properties props = new Properties();

				props.put("bootstrap.servers", "localhost:9092");
				props.put("group.id", "test");
				props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
				props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

				try (Consumer<String, String> consumer = new KafkaConsumer<String, String>(props)) {
					consumer.subscribe(Collections.singletonList("topic3"));
					try {
						while (true) {
							ConsumerRecords<String, String> records = consumer.poll(100);
							for (ConsumerRecord<String, String> record : records) {
								System.out.println("---------------------------------------------" + record.value()
										+ "---------------------------------------------");
							}
						}
					} finally {
						consumer.close();
					}

				}
			}
		};
		t.start();

	}

	public static void produceur(String key, String value, KafkaProducer<String, String> producer, String topic) {

		ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
		try {
			producer.send(record);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
