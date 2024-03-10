package micro.test.rdv.service;

import lombok.AllArgsConstructor;
import micro.test.rdv.command.RdvCommand;
import micro.test.rdv.mapper.RdvMapper;
import micro.test.rdv.model.Rdv;
import micro.test.rdv.repository.IRdvRepository;
import micro.test.rdv.representation.RdvRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RdvServiceImpl implements IRdvService {

    private IRdvRepository iRdvRepository ;
    private RdvMapper rdvMapper;
    @Override
    public RdvRepresentation createRdv (RdvCommand rdvCommand) {
        Rdv rdv = rdvMapper.convertCommandToEntity(rdvCommand);
        iRdvRepository.save(rdv);
        return rdvMapper.convertEntityToRepresentation(rdv);
    }

    @Override
    public RdvRepresentation updateRdv (RdvCommand rdvCommand) {
        Rdv rdv = rdvMapper.convertCommandToEntity(rdvCommand);
        iRdvRepository.save(rdv);
        return rdvMapper.convertEntityToRepresentation(rdv);
    }

    @Override
    public RdvRepresentation getRdvById (int id) {
        Rdv rdv = iRdvRepository.findById(id).get();
        return rdvMapper.convertEntityToRepresentation(rdv);
    }

    @Override
    public void deleteRdv (int id) {
        Rdv rdv = iRdvRepository.findById(id).get();
        iRdvRepository.delete(rdv);
    }

    @Override
    public List<RdvRepresentation> getAllRdv () {
        List<Rdv> all = iRdvRepository.findAll();
        return rdvMapper.convertListEntityToListRepresentation(all);
    }


}
