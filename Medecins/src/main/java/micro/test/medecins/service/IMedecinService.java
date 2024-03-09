package micro.test.medecins.service;

import micro.test.medecins.command.MedecinCommand;
import micro.test.medecins.representation.MedecinRepresentation;

import java.util.List;

public interface IMedecinService {
    public MedecinRepresentation createMedecin (MedecinCommand medecinCommand);
    public MedecinRepresentation updateMedecin (MedecinCommand medecinCommand);

    public MedecinRepresentation getMedecinById (int id);
    public void deleteMedecin (int id);
    public List<MedecinRepresentation> getAllMedecin ();


}
