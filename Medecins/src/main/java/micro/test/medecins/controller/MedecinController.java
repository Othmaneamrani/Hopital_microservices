package micro.test.medecins.controller;

import lombok.AllArgsConstructor;
import micro.test.medecins.command.MedecinCommand;
import micro.test.medecins.representation.MedecinRepresentation;
import micro.test.medecins.service.IMedecinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecin")
@AllArgsConstructor
public class MedecinController {

    private IMedecinService iMedecinService;

    @PostMapping("/create")
    public MedecinRepresentation createMedecin (@RequestBody MedecinCommand medecinCommand){
        return iMedecinService.createMedecin(medecinCommand) ;
    }

    @GetMapping("/all")
    public List<MedecinRepresentation> getAll(){
        return iMedecinService.getAllMedecin();
    }

    @GetMapping("/{id}")
    public MedecinRepresentation getById(@PathVariable int id){
        return iMedecinService.getMedecinById(id);
    }

    @PutMapping("/update")
    public MedecinRepresentation updateMedecin (@RequestBody MedecinCommand medecinCommand){
        return iMedecinService.updateMedecin(medecinCommand) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedecin (@PathVariable int id){
        iMedecinService.deleteMedecin(id); ;
    }

}
