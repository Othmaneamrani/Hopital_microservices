package micro.test.malade.repository;

import micro.test.malade.model.Malade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaladeRepository extends JpaRepository<Malade , Integer> {
}
