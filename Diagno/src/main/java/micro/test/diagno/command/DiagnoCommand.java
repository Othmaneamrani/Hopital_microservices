package micro.test.diagno.command;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiagnoCommand {
    private int idCommand;
    private String descriptionCommand;
    private int maladeIdCommand ;
    private int medecinIdCommand ;
    private Date dateCommand ;
}
