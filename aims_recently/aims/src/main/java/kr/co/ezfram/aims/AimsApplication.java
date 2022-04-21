package kr.co.ezfram.aims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AimsApplication.class, args);
	}

}
