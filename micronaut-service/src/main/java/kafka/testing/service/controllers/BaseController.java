package kafka.testing.service.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Error;

import kafka.testing.service.kafka.KafkaTopicProducer;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller(produces = MediaType.TEXT_PLAIN)
public class BaseController {
	private final KafkaTopicProducer producer;
	private final Logger log;

	public BaseController(KafkaTopicProducer producer) {
		this.producer = producer;
		this.log = LoggerFactory.getLogger(BaseController.class);
	}

	@Get
	public String index() {

		log.info("send kafka.random.n1");
		producer.send1(UUID.randomUUID().toString(), "message 1");

		log.info("send kafka.random.n2");
		producer.send2(UUID.randomUUID().toString(), "message 2");

		log.info("send kafka.random.n3");
		producer.send3(UUID.randomUUID().toString(), "message 3");

		log.info("send kafka.random.n4");
		producer.send4(UUID.randomUUID().toString(), "message 4");

		return "Hello World";
	}

	@Get("/error")
	public String getError() {


		log.info("send kafka.testing.unauthorized");
		producer.sendError(UUID.randomUUID().toString(), "error message");

		return "You won't see this.";
	}

	@Error(exception = Exception.class, global = true)
	public HttpResponse<String> errorHandler(Exception exception) {
		return HttpResponse
			.<String>ok()
			.body(exception.getMessage())
			.contentType(MediaType.TEXT_PLAIN);
	}
}