package kafka.testing.service;

import io.micronaut.runtime.Micronaut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try {
            Micronaut.run();
        } catch (Exception e) {
            log.error(e.getMessage());
            System.exit(1);
        }
    }
}