package micro.test.malade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MaladeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaladeApplication.class, args);
    }

}
