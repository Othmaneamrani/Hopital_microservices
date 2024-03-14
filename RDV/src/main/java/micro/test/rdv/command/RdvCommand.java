package micro.test.rdv.command;

import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RdvCommand {
    private int idCommand;

    private LocalDateTime dateCommand;

    private int maladeIdCommand;
    private int medecinIdCommand;
    private int chambreIdCommand;
}
