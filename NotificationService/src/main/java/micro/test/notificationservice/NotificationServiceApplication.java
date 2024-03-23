package micro.test.notificationservice;

import lombok.extern.slf4j.Slf4j;
import micro.test.notificationservice.model.Notif;
import micro.test.notificationservice.repository.INotifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NotificationServiceApplication {

    @Autowired
    private INotifRepository iNotifRepository;
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notifTopic")
    public void handleNotif (String string){
        log.info(string);
        iNotifRepository.save(Notif.builder().data(string).build());
    }


}
