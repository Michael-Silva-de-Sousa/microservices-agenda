package br.com.avocat.agenda;

import br.com.avocat.amqp.RabbitMQMessageProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableEurekaClient
@EnableMongoAuditing
@SpringBootApplication
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Bean
	public RabbitMQMessageProducer rabbitMQMessageProducer(){
		return new RabbitMQMessageProducer(amqpTemplate);
	}
}
