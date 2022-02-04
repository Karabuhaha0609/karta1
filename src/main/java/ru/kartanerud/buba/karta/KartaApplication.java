package ru.kartanerud.buba.karta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ru.kartanerud.buba.karta.security.SecurityAuditorAware;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class KartaApplication {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new SecurityAuditorAware();
	}


	public static void main(String[] args) {
		SpringApplication.run(KartaApplication.class, args);
	}

}
