package micro.test.chambre.repository;

import micro.test.chambre.model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChambreRepository extends JpaRepository<Chambre,Integer> {
}
