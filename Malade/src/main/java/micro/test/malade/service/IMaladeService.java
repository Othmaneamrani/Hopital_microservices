package micro.test.malade.service;

import micro.test.malade.command.MaladeCommand;
import micro.test.malade.representation.MaladeRepresentation;

import java.util.List;

public interface IMaladeService {

    public MaladeRepresentation createMalade (MaladeCommand maladeCommand);
    public MaladeRepresentation updateMalade (MaladeCommand maladeCommand);

    public MaladeRepresentation getMaladeById (int id);
    public void deleteMalade (int id);
    public List<MaladeRepresentation> getAllMalade ();

    List<MaladeRepresentation> getMaladeByChambreId (int id);



}
