package tp.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import com.fasterxml.jackson.databind.ObjectMapper;

import tp.kafka.service.SummaryService;

import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;


public class ConsumerCustom1 {
	
	@Autowired
	private static SummaryService summaryService;

	private static final Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        //props.put("enable.auto.commit","true");
        //props.put("auto.commit.interval.ms","1000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,IntegerDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        
        KafkaConsumer<Integer,Summary> consumer = new KafkaConsumer<Integer,Summary>(props);
       consumer.subscribe(Collections.singletonList("topic1"));
        
        int noMessageToFetch = 0;

		while (true) {
			final ConsumerRecords<Integer, Summary> records = consumer.poll(Duration.ofMillis(1000));
			if (records.count() == 0) {
				noMessageToFetch++;
				if (noMessageToFetch > 50)
					break;
				else
					continue;
			}

			records.forEach(record -> {
				//System.out.println("Record Key " + record.key());
				System.out.println("Record value " + record.value());
				System.out.println("Record partition " + record.partition());
				System.out.println("Record offset " + record.offset());
				Summary s = null;
				s = summaryService.createSummary(record.value());
			});
			consumer.commitAsync();
		}
		consumer.close();
	}

}
