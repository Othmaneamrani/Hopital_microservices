package micro.test.diagno.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "diagno")
public class Diagno {
    @Id
    private int id;
    private String description;
    private int maladeId ;
    private int medecinId ;
    private Date date ;

}
