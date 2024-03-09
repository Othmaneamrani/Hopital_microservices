package micro.test.rdv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="rdv")
public class Rdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    


}
