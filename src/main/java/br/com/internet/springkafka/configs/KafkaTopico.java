package br.com.internet.springkafka.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopico {

	@Value(value = "${bootstrap.server}")
	private String server;
	
	@Bean
	public KafkaAdmin admin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, server);
		return new KafkaAdmin(configs);
	}
	@Bean
	public NewTopic topic1() {
		return new NewTopic("topico_teste", 10, (short) 1);
	}
}
