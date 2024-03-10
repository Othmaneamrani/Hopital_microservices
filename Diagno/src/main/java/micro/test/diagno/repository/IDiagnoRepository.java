package micro.test.diagno.repository;

import micro.test.diagno.model.Diagno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDiagnoRepository extends MongoRepository<Diagno , Integer> {
}
