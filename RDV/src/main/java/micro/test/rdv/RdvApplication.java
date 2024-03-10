package micro.test.rdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RdvApplication {

    public static void main(String[] args) {
        SpringApplication.run(RdvApplication.class, args);
    }

}
