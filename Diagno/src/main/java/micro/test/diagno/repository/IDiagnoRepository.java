package micro.test.diagno.repository;

import micro.test.diagno.model.Diagno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IDiagnoRepository extends MongoRepository<Diagno , Integer> {
    public List<Diagno> findByMedecinId(int id);
    public List<Diagno> findByMaladeId(int id);

}
