package micro.test.chambre.controller;

import lombok.AllArgsConstructor;
import micro.test.chambre.command.ChambreCommand;
import micro.test.chambre.representation.ChambreRepresentation;
import micro.test.chambre.service.IChambreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreController {

    private IChambreService iChambreService;

    @PostMapping("/create")
    public ChambreRepresentation createChambre (@RequestBody ChambreCommand chambreCommand){
        return iChambreService.createChambre(chambreCommand) ;
    }

    @GetMapping("/all")
    public List<ChambreRepresentation> getAll(){
        return iChambreService.getAllChambre();
    }

    @GetMapping("/{id}")
    public ChambreRepresentation getById(@PathVariable int id){
        return iChambreService.getChambreById(id);
    }

    @PutMapping("/update")
    public ChambreRepresentation updateChambre (@RequestBody ChambreCommand chambreCommand){
        return iChambreService.updateChambre(chambreCommand) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChambre (@PathVariable int id){
        iChambreService.deleteChambre(id); ;
    }

    @GetMapping("/dispo/{id}")
    public Boolean chambreDispo (@PathVariable int id){
        return iChambreService.chambrePresente(id);
    }


    @PatchMapping("/remove/{id}")
    public ChambreRepresentation removeFromChambre(@PathVariable int id){
        return iChambreService.removeFromChambre(id);
    }

    @PatchMapping("/insert/{id}")
    public ChambreRepresentation insertIntoChambre(@PathVariable int id){
        return iChambreService.insertIntoChambre(id);
    }

}
