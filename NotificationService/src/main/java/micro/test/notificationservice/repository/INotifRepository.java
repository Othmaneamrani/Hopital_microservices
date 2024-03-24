package micro.test.notificationservice.repository;

import micro.test.notificationservice.kafka.Notif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotifRepository extends JpaRepository<Notif,Integer> {
}
