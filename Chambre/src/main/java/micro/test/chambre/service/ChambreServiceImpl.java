package micro.test.chambre.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import micro.test.chambre.command.ChambreCommand;
import micro.test.chambre.mapper.ChambreMapper;
import micro.test.chambre.model.Chambre;
import micro.test.chambre.repository.IChambreRepository;
import micro.test.chambre.representation.ChambreRepresentation;
import micro.test.chambre.representation.MaladeRepresentation;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private IChambreRepository iChambreRepository;
    private ChambreMapper chambreMapper;
    private WebClient.Builder webClientBuilder;
    private KafkaTemplate<String,String> kafkaTemplate;
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
    public ChambreRepresentation removeFromChambre(int idChambre , int idMalade) {
        Chambre chambre = iChambreRepository.findById(idChambre).get();
        if(chambre.getUtilise() > 0) {
            chambre.setUtilise(chambre.getUtilise() - 1);
        }else{
            throw new RuntimeException("Chambre vide.");
        }
        chambre.setDispo(chambre.getCapacite() != chambre.getUtilise());

        webClientBuilder.build().get()
                        .uri("http://localhost:8081/malade/setchambre?idChambre=" + 0 +"&idMalade=" + idMalade)
                                .retrieve()
                                .bodyToMono(MaladeRepresentation.class)
                                .subscribe(
                                    maladeRepresentation -> {
                                        System.out.println("Réponse reçue : " + maladeRepresentation.getChambreIdRepresentation());
                                    },
                                    error -> {
                                        System.err.println("Une erreur s'est produite lors de la requête WebClient : " + error.getMessage());
                                });

        iChambreRepository.save(chambre);
        kafkaTemplate.send("notifTopic","chambre -- malade N°"+idMalade);
        return chambreMapper.convertEntityToRepresentation(chambre);
    }

    @Override
    public ChambreRepresentation insertIntoChambre(int idChambre , int idMalade) {
        Chambre chambre = iChambreRepository.findById(idChambre).get();
        if(chambre.getDispo()) {
            chambre.setUtilise(chambre.getUtilise() + 1);
            chambre.setDispo(chambre.getCapacite() != chambre.getUtilise());

            webClientBuilder.build().get()
                    .uri("http://localhost:8081/malade/setchambre?idChambre=" + idChambre +"&idMalade=" + idMalade)
                    .retrieve()
                    .bodyToMono(MaladeRepresentation.class)
                    .subscribe( // Abonnement à la réponse
                            maladeRepresentation -> {
                                System.out.println("Réponse reçue : " + maladeRepresentation.getChambreIdRepresentation());
                            },
                            error -> {
                                System.err.println("Une erreur s'est produite lors de la requête WebClient : " + error.getMessage());
                            });

            iChambreRepository.save(chambre);
            kafkaTemplate.send("notifTopic","chambre ++ malade N°"+idMalade);

        }else{
            throw new RuntimeException("Chambre pleine.");
        }
        return chambreMapper.convertEntityToRepresentation(chambre);
    }


}
