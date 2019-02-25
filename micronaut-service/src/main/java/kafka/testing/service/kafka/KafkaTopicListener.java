package kafka.testing.service.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class KafkaTopicListener {
    private static final Logger log = LoggerFactory.getLogger(KafkaTopicListener.class);

    @Topic("kafka.random.n1")
    public void receive1(String message) {
        log.info("receive kafka.random.n1: " + message);
    }

    @Topic("kafka.random.n2")
    public void receive2(String message) {
        log.info("receive kafka.random.n2: " + message);
    }

    @Topic("kafka.testing.unauthorized")
    public void receiveError(String message) {
        log.info("receive kafka.testing.unauthorized: " + message);
    }

    @Topic("kafka.random.n3")
    public void receive3(String message) {
        log.info("receive kafka.random.n3: " + message);
    }

    @Topic("kafka.random.n4")
    public void receive4(String message) {
        log.info("receive kafka.random.n4: " + message);
    }
}
