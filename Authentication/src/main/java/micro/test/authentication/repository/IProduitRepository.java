package micro.test.authentication.repository;

import micro.test.authentication.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduitRepository extends JpaRepository<Produit , Integer> {
}
