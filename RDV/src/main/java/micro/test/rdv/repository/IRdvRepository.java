package micro.test.rdv.repository;

import micro.test.rdv.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRdvRepository extends JpaRepository<Rdv,Integer> {

    public List<Rdv> findByMedecinId(int id);
    public List<Rdv> findByMaladeId(int id);


}
