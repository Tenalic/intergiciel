package tp.kafka.consumer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDeserializer implements Deserializer<Summary> {
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public Summary deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		Summary object = null;
		try {
			object = mapper.readValue(data, Summary.class);
		} catch (Exception exception) {
			System.out.println("Erreur de désérialization des octets " + exception);
		}
		return object;
	}

	@Override
	public void close() {
	}
}
