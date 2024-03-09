package micro.test.rdv.repository;

import micro.test.rdv.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRdvRepository extends JpaRepository<Rdv,Integer> {
}
