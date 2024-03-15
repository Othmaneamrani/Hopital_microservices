package micro.test.diagno.representation;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaladeRepresentation {
    private int idRepresentation;
    private String nomRepresentation;
    private String prenomRepresentation;
    private String emailRepresentation;
    private String usernameRepresentation;
    private int chambreIdRepresentation;
}
