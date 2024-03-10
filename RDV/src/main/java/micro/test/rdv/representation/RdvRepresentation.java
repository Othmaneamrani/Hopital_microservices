package micro.test.rdv.representation;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RdvRepresentation {
    private int idRepresentation;

    private Date dateRepresentation;

    private int maladeIdRepresentation;
    private int medecinIdRepresentation;
    private int chambreIdRepresentation;
}
