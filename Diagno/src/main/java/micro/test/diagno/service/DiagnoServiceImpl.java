package micro.test.diagno.service;

import lombok.AllArgsConstructor;
import micro.test.diagno.command.DiagnoCommand;
import micro.test.diagno.mapper.DiagnoMapper;
import micro.test.diagno.model.Diagno;
import micro.test.diagno.repository.IDiagnoRepository;
import micro.test.diagno.representation.DiagnoRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiagnoServiceImpl implements IDiagnoService {

    private IDiagnoRepository iDiagnoRepository ;
    private DiagnoMapper diagnoMapper ;

    @Override
    public DiagnoRepresentation createDiagno(DiagnoCommand diagnoCommand) {
        Diagno diagno = diagnoMapper.convertCommandToEntity(diagnoCommand);
        iDiagnoRepository.save(diagno);
        return diagnoMapper.convertEntityToRepresentation(diagno);
    }
    @Override
    public DiagnoRepresentation updateDiagno(DiagnoCommand diagnoCommand) {
        Diagno diagno = diagnoMapper.convertCommandToEntity(diagnoCommand);
        iDiagnoRepository.save(diagno);
        return diagnoMapper.convertEntityToRepresentation(diagno);
    }

    @Override
    public DiagnoRepresentation getDiagnoById(int id) {
        Diagno diagno = iDiagnoRepository.findById(id).get();
        return diagnoMapper.convertEntityToRepresentation(diagno);
    }

    @Override
    public void deleteDiagno(int id) {
        Diagno diagno = iDiagnoRepository.findById(id).get();
        iDiagnoRepository.delete(diagno);
    }

    @Override
    public List<DiagnoRepresentation> getAllDiagno() {
            List<Diagno> all = iDiagnoRepository.findAll();
            return diagnoMapper.convertListEntityToListRepresentation(all);
        }

    @Override
    public List<DiagnoRepresentation> findDiagnoByMedecinId(int id) {
        List<Diagno> diagnos = iDiagnoRepository.findByMedecinId(id);
        return diagnoMapper.convertListEntityToListRepresentation(diagnos);
    }

    @Override
    public List<DiagnoRepresentation> findDiagnoByMaladeId(int id) {
        List<Diagno> diagnos = iDiagnoRepository.findByMaladeId(id);
        return diagnoMapper.convertListEntityToListRepresentation(diagnos);
    }

}
