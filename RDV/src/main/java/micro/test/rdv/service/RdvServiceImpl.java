package micro.test.rdv.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import micro.test.rdv.command.RdvCommand;
import micro.test.rdv.mapper.RdvMapper;
import micro.test.rdv.model.Rdv;
import micro.test.rdv.repository.IRdvRepository;
import micro.test.rdv.representation.RdvRepresentation;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RdvServiceImpl implements IRdvService {

    private IRdvRepository iRdvRepository ;
    private RdvMapper rdvMapper;
    @Override
    public RdvRepresentation createRdv (RdvCommand rdvCommand) {
        Rdv rdv = rdvMapper.convertCommandToEntity(rdvCommand);
        List<Rdv> all = iRdvRepository.findAll();
        for(Rdv r : all){
            long between = ChronoUnit.MINUTES.between(r.getDate(), rdv.getDate());
            if (rdv.getMedecinId() == r.getMedecinId() && (rdv.getDate().isEqual(r.getDate()) || between <=15 ) )  {
                throw new RuntimeException("Date déjà réservée.");
            }
        }
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


    @Override
    public List<RdvRepresentation> findRdvByMedecinId(int id) {
        List<Rdv> rdvs = iRdvRepository.findByMedecinId(id);
        return rdvMapper.convertListEntityToListRepresentation(rdvs);
    }

    @Override
    public List<RdvRepresentation> findRdvByMaladeId(int id) {
        List<Rdv> rdvs = iRdvRepository.findByMaladeId(id);
        return rdvMapper.convertListEntityToListRepresentation(rdvs);
    }



}
