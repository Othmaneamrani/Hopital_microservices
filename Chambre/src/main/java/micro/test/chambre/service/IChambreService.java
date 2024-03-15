package micro.test.chambre.service;

import micro.test.chambre.command.ChambreCommand;
import micro.test.chambre.representation.ChambreRepresentation;

import java.util.List;

public interface IChambreService {

    public ChambreRepresentation createChambre (ChambreCommand chambreCommand  );
    public ChambreRepresentation updateChambre  (ChambreCommand chambreCommand );

    public ChambreRepresentation getChambreById (int id);
    public void deleteChambre  (int id);
    public List<ChambreRepresentation> getAllChambre ();
    public Boolean chambrePresente(int id);

    public ChambreRepresentation removeFromChambre(int idChambre , int idMalade);
    public ChambreRepresentation insertIntoChambre(int idChambre , int idMalade);

}
