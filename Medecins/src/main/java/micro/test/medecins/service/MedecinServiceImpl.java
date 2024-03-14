package micro.test.medecins.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import micro.test.medecins.command.MedecinCommand;
import micro.test.medecins.mapper.MedecinMapper;
import micro.test.medecins.model.Medecin;
import micro.test.medecins.repository.IMedecinRepository;
import micro.test.medecins.representation.MedecinRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MedecinServiceImpl implements IMedecinService{

private IMedecinRepository iMedecinRepository;
private MedecinMapper medecinMapper;
    @Override
    public MedecinRepresentation createMedecin(MedecinCommand medecinCommand) {
        Medecin medecin = medecinMapper.convertCommandToEntity(medecinCommand);
        iMedecinRepository.save(medecin);
        return medecinMapper.convertEntityToRepresentation(medecin);
    }

    @Override
    public MedecinRepresentation updateMedecin(MedecinCommand medecinCommand) {
        Medecin medecin = medecinMapper.convertCommandToEntity(medecinCommand);
        iMedecinRepository.save(medecin);
        return medecinMapper.convertEntityToRepresentation(medecin);
    }

    @Override
    public MedecinRepresentation getMedecinById(int id) {
        Medecin medecin = iMedecinRepository.findById(id).get();
        return medecinMapper.convertEntityToRepresentation(medecin);
    }

    @Override
    public void deleteMedecin(int id) {
        Medecin medecin = iMedecinRepository.findById(id).get();
        iMedecinRepository.delete(medecin);
    }

    @Override
    public List<MedecinRepresentation> getAllMedecin() {
        List<Medecin> all = iMedecinRepository.findAll();
        return medecinMapper.convertListEntityToListRepresentation(all);
    }



}
