package micro.test.chambre.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import micro.test.chambre.command.ChambreCommand;
import micro.test.chambre.mapper.ChambreMapper;
import micro.test.chambre.model.Chambre;
import micro.test.chambre.repository.IChambreRepository;
import micro.test.chambre.representation.ChambreRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private IChambreRepository iChambreRepository;
    private ChambreMapper chambreMapper;
    @Override
    public ChambreRepresentation createChambre (ChambreCommand chambreCommand  ) {
        Chambre chambre = chambreMapper.convertCommandToEntity(chambreCommand);
        chambre.setDispo(chambre.getCapacite() != chambre.getUtilise());
        iChambreRepository.save(chambre);
        return chambreMapper.convertEntityToRepresentation(chambre);
    }

    @Override
    public ChambreRepresentation updateChambre  (ChambreCommand chambreCommand ) {
        Chambre chambre = chambreMapper.convertCommandToEntity(chambreCommand);
        chambre.setDispo(chambre.getCapacite() != chambre.getUtilise());
        iChambreRepository.save(chambre);
        return chambreMapper.convertEntityToRepresentation(chambre);
    }

    @Override
    public ChambreRepresentation getChambreById (int id) {
        Chambre chambre = iChambreRepository.findById(id).get();
        return chambreMapper.convertEntityToRepresentation(chambre);
    }

    @Override
    public void deleteChambre  (int id) {
        Chambre chambre = iChambreRepository.findById(id).get();
        iChambreRepository.delete(chambre);
    }

    @Override
    public List<ChambreRepresentation> getAllChambre () {
        List<Chambre> all = iChambreRepository.findAll();
        return chambreMapper.convertListEntityToListRepresentation(all);
    }

    @Override
    public Boolean chambrePresente(int id) {
        Chambre chambre = iChambreRepository.findById(id).get();
        return chambre.getDispo();
    }

    @Override
    public ChambreRepresentation removeFromChambre(int id) {
        Chambre chambre = iChambreRepository.findById(id).get();
        if(chambre.getUtilise() > 0) {
            chambre.setUtilise(chambre.getUtilise() - 1);
        }else{
            throw new RuntimeException("Chambre vide.");
        }
        chambre.setDispo(chambre.getCapacite() != chambre.getUtilise());
        iChambreRepository.save(chambre);
        return chambreMapper.convertEntityToRepresentation(chambre);
    }

    @Override
    public ChambreRepresentation insertIntoChambre(int id) {
        Chambre chambre = iChambreRepository.findById(id).get();
        if(chambre.getDispo()) {
            chambre.setUtilise(chambre.getUtilise() + 1);
            chambre.setDispo(chambre.getCapacite() != chambre.getUtilise());
            iChambreRepository.save(chambre);
        }else{
            throw new RuntimeException("Chambre non disponible.");
        }
        return chambreMapper.convertEntityToRepresentation(chambre);
    }


}
