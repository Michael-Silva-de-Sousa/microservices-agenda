package br.com.avocat.notificacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NotificacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacaoApplication.class, args);
	}

}
