package tn.esprit.etudiantservice;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.*;
import org.springframework.cloud.client.discovery.*;
import org.springframework.cloud.context.config.annotation.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;
import tn.esprit.etudiantservice.Configuration.*;
import tn.esprit.etudiantservice.services.utils.*;

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableFeignClients
@EnableDiscoveryClient
@RefreshScope
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class EtudiantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantServiceApplication.class, args);
	}


}
