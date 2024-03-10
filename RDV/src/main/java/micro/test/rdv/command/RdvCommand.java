package micro.test.rdv.command;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RdvCommand {
    private int idCommand;

    private Date dateCommand;

    private int maladeIdCommand;
    private int medecinIdCommand;
    private int chambreIdCommand;
}
