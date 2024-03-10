package micro.test.diagno.service;

import micro.test.diagno.command.DiagnoCommand;
import micro.test.diagno.representation.DiagnoRepresentation;

import java.util.List;

public interface IDiagnoService {

    public DiagnoRepresentation createDiagno (DiagnoCommand diagnoCommand  );
    public DiagnoRepresentation updateDiagno  (DiagnoCommand diagnoCommand );

    public DiagnoRepresentation getDiagnoById (int id);
    public void deleteDiagno (int id);
    public List<DiagnoRepresentation> getAllDiagno ();

}
