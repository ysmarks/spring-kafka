package br.com.internet.springkafka.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
@Configuration
public class KafkaProdutor {

	@Value(value = "${bootstrap.server}")
	private String server;
	@Bean
	public ProducerFactory<Integer, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(prodiceConfigs());
		
	}
	@Bean
	public Map<String, Object> prodiceConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}
	@Bean
	public KafkaTemplate<Integer, String> kafkaTemplate() {
		return new KafkaTemplate<Integer, String>(producerFactory());
	}
}
