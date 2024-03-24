package micro.test.notificationservice;

import lombok.extern.slf4j.Slf4j;
import micro.test.notificationservice.kafka.Notif;
import micro.test.notificationservice.repository.INotifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.function.Function;


@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NotificationServiceApplication {

    @Autowired
    private INotifRepository iNotifRepository;

    @Bean
    public Function<Notif,Notif> notifFunction (){
        return (input)-> {
            input.setData("Function :" + input.getData());
            iNotifRepository.save(input);
            return input;
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

//    @KafkaListener(topics = "notifTopic")
//    public void handleNotif (String string){
//        log.info(string);
//        iNotifRepository.save(Notif.builder().data(string).build());
//    }



}
