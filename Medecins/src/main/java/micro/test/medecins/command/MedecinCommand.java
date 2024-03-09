package micro.test.medecins.command;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedecinCommand {
    private int idCommand;
    private String nomCommand;
    private String prenomCommand;
    private String emailCommand;
    private String usernameCommand;
}
