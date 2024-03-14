package micro.test.malade.repository;

import micro.test.malade.model.Malade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMaladeRepository extends JpaRepository<Malade , Integer> {
    List<Malade> getMaladeByChambreId (int id);

}
