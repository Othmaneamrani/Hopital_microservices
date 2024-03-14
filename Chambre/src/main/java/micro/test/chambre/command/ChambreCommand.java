package micro.test.chambre.command;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChambreCommand {
    private int idCommand;
    private int etageCommand;
    private int tailleCommand;
    private int capaciteCommand;
    private int utiliseCommand;
    private Boolean dispoCommand;

}
