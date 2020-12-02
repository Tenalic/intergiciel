package intergiciel;

import intergiciel.constants.IKafkaConstants;
import intergiciel.consumer.ConsumerCreator;
import intergiciel.produceur.ProducerCreator;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.OffsetAndTimestamp;
import org.apache.kafka.clients.consumer.OffsetCommitCallback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

/**
 * 
 * @author Stephane
 *
 */
public class Cs {

	static void runConsumer() {
		Consumer<Long, String> consumer = ConsumerCreator.createConsumer();

		int noMessageToFetch = 0;

		while (true) {
			final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
			if (consumerRecords.count() == 0) {
				noMessageToFetch++;
				if (noMessageToFetch > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
					break;
				else
					continue;
			}

			consumerRecords.forEach(record -> {
				System.out.println("Record Key " + record.key());
				System.out.println("Record value " + record.value());
				System.out.println("Record partition " + record.partition());
				System.out.println("Record offset " + record.offset());
			});
			consumer.commitAsync();
		}
		consumer.close();
	}

	static void runProducer() {
		Producer<Long, String> producer = ProducerCreator.createProducer();

		for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
			final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(IKafkaConstants.TOPIC_NAME,
					"Enregistrement N° " + index);
			try {
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Enregistrement envoyer avec clè " + index + " vers la partition "
						+ metadata.partition() + " Et l'offset " + metadata.offset());
			} catch (ExecutionException e) {
				System.out.println("Erreur dans l'envoi de l'enregistrement");
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println("Erreur dans l'envoi de l'enregistrement");
				System.out.println(e);
			}
		}
	}

	static void runProducer2() {
		Producer<Long, String> producer = ProducerCreator.createProducer();
		String test = "test";
		final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(IKafkaConstants.TOPIC_NAME, test);
		try {
			RecordMetadata metadata = producer.send(record).get();
			// System.out.println("Enregistrement envoyer avec clè " + test + " vers la
			// partition " + metadata.partition() + " Et l'offset " + metadata.offset());
		} catch (ExecutionException e) {
			System.out.println("Erreur dans l'envoi de l'enregistrement");
			// System.out.println(e);
		} catch (InterruptedException e) {
			System.out.println("Erreur dans l'envoi de l'enregistrement");
			// System.out.println(e);
		}
	}

	static void testConsumer() {
		Properties props = new Properties();

		props.put("bootstrap.servers", "localhost:9092");
		//props.put("group.id", "autre");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		try (Consumer<String, String> consumer = new KafkaConsumer<String, String>(props)) {
			consumer.subscribe(Collections.singletonList("tptopic"));
			try {
				while (true) {
					ConsumerRecords<String, String> records = consumer.poll(100);
					for (ConsumerRecord<String, String> record : records) {
						/*System.out.println("topic =" + record.topic() + " , partition = " + record.partition()
								+ " , offset = " + record.offset() + ", customer = " + record.key() + ", country = "
								+ record.value());*/
						System.out.println("bonjour");
						/*int updatedCount = 1;
						if (custCountryMap.countainsValue(record.value())) {
							updatedCount = custCountryMap.get(record.value()) + 1;
						}
						custCountryMap.put(record.value(), updatedCount);
						JSONObject json = new JSONObject(custCountryMap);
						System.out.println(json.toString(4));*/
					}
				}
			} finally {
				consumer.close();
			}

		}

	}

	static void testProduceur() {
		Properties kafkaProps = new Properties(); // (1)

		kafkaProps.put("bootstrap.servers", "localhost:9092"); // (2)
		kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		try (KafkaProducer<String, String> producer = new KafkaProducer<String, String>(kafkaProps)) {
			ProducerRecord<String, String> record = new ProducerRecord<>("tptopic", "test", "France");// (1)
			try {
				producer.send(record); // (2)
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// runProducer();
		testProduceur();
		testConsumer();
	}

}
