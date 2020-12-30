package tp.kafka.producer;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ProducerCustom1 {

	 private static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "producer1");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();

        KafkaProducer<Integer,Summary> producer = new KafkaProducer<Integer, Summary>(props);
        
        try {
            // Reading json record from Summary.json file
            Summary summary = mapper.readValue(Paths.get("data/Summary.json").toFile(), Summary.class);

            logger.info("Producer is created....");
            
                ProducerRecord<Integer, Summary> record = new ProducerRecord<Integer, Summary>("topic1",
                        summary);
                producer.send(record, new Callback() {
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        if (e != null)
                            System.out.println(e.getMessage());
                        else
                            System.out.println(metadata.topic() + " : " + metadata.partition() + " : " + metadata.offset());
                    }
                });
            
            }catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        producer.close();
	}

}
