package micro.test.diagno.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import micro.test.diagno.command.DiagnoCommand;

import micro.test.diagno.mapper.DiagnoMapper;
import micro.test.diagno.model.Diagno;
import micro.test.diagno.repository.IDiagnoRepository;
import micro.test.diagno.representation.DiagnoRepresentation;
import micro.test.diagno.representation.MaladeRepresentation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DiagnoServiceImpl implements IDiagnoService {

    private IDiagnoRepository iDiagnoRepository ;
    private DiagnoMapper diagnoMapper ;
    private WebClient.Builder webClientBuilder;


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

//    @Override
//    public List<MaladeRepresentation> findMaladeByIdMedecin(int id) {
//        List<Diagno> diagnos = iDiagnoRepository.findByMedecinId(id);
//        List<MaladeRepresentation> malades = new ArrayList<>();
//        for (Diagno d : diagnos){
//            RestClient restClient = RestClient.create("http://localhost:8081");
//            MaladeRepresentation malade = restClient.get()
//                    .uri("/malade/" + d.getMaladeId())
//                    .retrieve()
//                    .body(MaladeRepresentation.class);
//            malades.add(malade);
//        }
//        return malades;
//    }



//    @Override
//    public Flux<MaladeRepresentation> findMaladeByIdMedecin(int id) {
//        return Flux.fromIterable(iDiagnoRepository.findByMedecinId(id))
//                .flatMapSequential(diagno -> webClientBuilder.build().get()
//                        .uri("http://localhost:8081/malade/" + diagno.getMaladeId())
//                        .retrieve()
//                        .bodyToMono(MaladeRepresentation.class));
//    }

    @Override
    public Flux<MaladeRepresentation> findMaladeByIdMedecin(int id) {
        List<Diagno> byMedecinId = iDiagnoRepository.findByMedecinId(id);
        List<Integer> list = byMedecinId.stream().map(d -> d.getMaladeId()).toList();
        return Flux.fromIterable(list)
                .flatMapSequential(m-> webClientBuilder.build().get()
                        .uri("http://localhost:8081/malade",
                                uriBuilder -> uriBuilder.queryParam("ids",m).build())
                        .retrieve()
                        .bodyToFlux(MaladeRepresentation.class));
    }


}
