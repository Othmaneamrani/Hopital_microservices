package micro.test.malade.representation;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaladeRepresentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRepresentation;
    private String nomRepresentation ;
    private String prenomRepresentation ;
    private String emailRepresentation ;
    private String usernameRepresentation ;
}