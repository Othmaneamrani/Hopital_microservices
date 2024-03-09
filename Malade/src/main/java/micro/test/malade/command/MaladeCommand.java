package micro.test.malade.command;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaladeCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommand ;
    private String nomCommand ;
    private String prenomCommand ;
    private String emailCommand ;
    private String usernameCommand ;
}
