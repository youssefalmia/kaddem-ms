package tn.esprit.universityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.*;
import org.springframework.cloud.context.config.annotation.*;
import org.springframework.cloud.openfeign.*;

@SpringBootApplication
@EnableFeignClients
@RefreshScope
@EnableDiscoveryClient
public class UniversityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityServiceApplication.class, args);
	}

}
