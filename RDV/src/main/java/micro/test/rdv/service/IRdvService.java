package micro.test.rdv.service;

import micro.test.rdv.command.RdvCommand;
import micro.test.rdv.representation.RdvRepresentation;

import java.util.List;

public interface IRdvService {

    public RdvRepresentation createRdv (RdvCommand rdvCommand);
    public RdvRepresentation updateRdv (RdvCommand rdvCommand);

    public RdvRepresentation getRdvById (int id);
    public void deleteRdv (int id);
    public List<RdvRepresentation> getAllRdv ();

}
