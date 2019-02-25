package kafka.testing.service.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface KafkaTopicProducer {
    @Topic("kafka.random.n1")
    void send1(@KafkaKey String key, String value);

    @Topic("kafka.random.n2")
    void send2(@KafkaKey String key, String value);

    @Topic("kafka.random.n3")
    void send3(@KafkaKey String key, String value);

    @Topic("kafka.random.n4")
    void send4(@KafkaKey String key, String value);

    @Topic("kafka.testing.unauthorized")
    void sendError(@KafkaKey String key, String value);
}
