package micro.test.chambre.representation;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChambreRepresentation {
    private int idRepresentation;
    private int etageRepresentation;
    private int tailleRepresentation;
    private int capaciteRepresentation;
    private int utiliseRepresentation;
    private Boolean dispoRepresentation;

}