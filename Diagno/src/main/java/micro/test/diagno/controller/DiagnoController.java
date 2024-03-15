package micro.test.diagno.controller;

import lombok.AllArgsConstructor;
import micro.test.diagno.command.DiagnoCommand;
import micro.test.diagno.representation.DiagnoRepresentation;
import micro.test.diagno.representation.MaladeRepresentation;
import micro.test.diagno.service.IDiagnoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/diagno")
@AllArgsConstructor
public class DiagnoController {

    private IDiagnoService iDiagnoService ;

    @PostMapping("/create")
    public DiagnoRepresentation createDiagno (@RequestBody DiagnoCommand diagnoCommand){
        return iDiagnoService.createDiagno(diagnoCommand) ;
    }

    @GetMapping("/all")
    public List<DiagnoRepresentation> getAll(){
        return iDiagnoService.getAllDiagno();
    }

    @GetMapping("/{id}")
    public DiagnoRepresentation getById(@PathVariable int id){
        return iDiagnoService.getDiagnoById(id);
    }

    @PutMapping("/update")
    public DiagnoRepresentation updateDiagno (@RequestBody DiagnoCommand diagnoCommand){
        return iDiagnoService.updateDiagno(diagnoCommand) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDiagno (@PathVariable int id){
        iDiagnoService.deleteDiagno(id); ;
    }

    @GetMapping("/medecin/{id}")
    public List<DiagnoRepresentation> findDiagnoByMedecinId (@PathVariable int id){
        return iDiagnoService.findDiagnoByMedecinId(id) ;
    }


    @GetMapping("/malade/{id}")
    public List<DiagnoRepresentation> findDiagnoByMaladeId (@PathVariable int id){
        return iDiagnoService.findDiagnoByMaladeId(id) ;
    }


    @GetMapping("/malades/{id}")
    public Flux<MaladeRepresentation> findMaladeByIdMedecin(@PathVariable int id) {
    return iDiagnoService.findMaladeByIdMedecin(id);
    }


}
