package micro.test.diagno.service;

import micro.test.diagno.command.DiagnoCommand;

import micro.test.diagno.representation.DiagnoRepresentation;
import micro.test.diagno.representation.MaladeRepresentation;

import java.util.List;

public interface IDiagnoService {

    public DiagnoRepresentation createDiagno (DiagnoCommand diagnoCommand  );
    public DiagnoRepresentation updateDiagno  (DiagnoCommand diagnoCommand );

    public DiagnoRepresentation getDiagnoById (int id);
    public void deleteDiagno (int id);
    public List<DiagnoRepresentation> getAllDiagno ();
    public List<DiagnoRepresentation> findDiagnoByMedecinId (int id);
    public List<DiagnoRepresentation> findDiagnoByMaladeId (int id);
    public List<MaladeRepresentation> findMaladeByIdMedecin(int id) ;


}
