package br.com.internet.springkafka.configs;

import org.apache.kafka.clients.producer.RecordMetadata;

public interface ProduceListener<K,V> {

	void onSuccess(String topico, Integer partition, K key, V value, RecordMetadata recordMetadata);
	void onError(String topico, Integer partition, K key, V value, Exception exception);
}
