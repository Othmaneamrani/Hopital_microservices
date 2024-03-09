package micro.test.medecins.repository;

import micro.test.medecins.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedecinRepository extends JpaRepository<Medecin , Integer> {
}
