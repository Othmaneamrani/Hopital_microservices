package micro.test.malade.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import micro.test.malade.command.MaladeCommand;
import micro.test.malade.mapper.MaladeMapper;
import micro.test.malade.model.Malade;
import micro.test.malade.repository.IMaladeRepository;
import micro.test.malade.representation.MaladeRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MaladeServiceImpl implements IMaladeService {

    private IMaladeRepository iMaladeRepository;
    private MaladeMapper maladeMapper;
    @Override
    public MaladeRepresentation createMalade (MaladeCommand maladeCommand) {
        Malade malade = maladeMapper.convertCommandToEntity(maladeCommand);
        iMaladeRepository.save(malade);
        return maladeMapper.convertEntityToRepresentation(malade);
    }

    @Override
    public MaladeRepresentation updateMalade (MaladeCommand maladeCommand) {
        Malade malade = maladeMapper.convertCommandToEntity(maladeCommand);
        iMaladeRepository.save(malade);
        return maladeMapper.convertEntityToRepresentation(malade);
    }

    @Override
    public MaladeRepresentation getMaladeById (int id) {
        Malade malade = iMaladeRepository.findById(id).get();
        return maladeMapper.convertEntityToRepresentation(malade);
    }

    @Override
    public void deleteMalade (int id) {
        Malade medecin = iMaladeRepository.findById(id).get();
        iMaladeRepository.delete(medecin);
    }

    @Override
    public List<MaladeRepresentation> getAllMalade () {
        List<Malade> all = iMaladeRepository.findAll();
        return maladeMapper.convertListEntityToListRepresentation(all);
    }

    @Override
    public List<MaladeRepresentation> getMaladeByChambreId(int id) {
        return maladeMapper.convertListEntityToListRepresentation(iMaladeRepository.getMaladeByChambreId(id));
    }


}
