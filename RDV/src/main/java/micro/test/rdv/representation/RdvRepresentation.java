package micro.test.rdv.representation;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RdvRepresentation {
    private int idRepresentation;

    private LocalDateTime dateRepresentation;

    private int maladeIdRepresentation;
    private int medecinIdRepresentation;
    private int chambreIdRepresentation;
}
