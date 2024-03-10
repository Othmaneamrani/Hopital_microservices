package micro.test.diagno.representation;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiagnoRepresentation {

    private int idRepresentation;
    private String descriptionRepresentation;
    private int maladeIdRepresentation ;
    private int medecinIdRepresentation;
    private Date dateRepresentation ;

}
