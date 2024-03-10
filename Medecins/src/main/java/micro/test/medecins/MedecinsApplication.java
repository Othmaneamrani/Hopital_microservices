package micro.test.medecins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MedecinsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedecinsApplication.class, args);
    }

}
