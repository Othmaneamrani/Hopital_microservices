package micro.test.rdv.controller;

import lombok.AllArgsConstructor;
import micro.test.rdv.command.RdvCommand;
import micro.test.rdv.representation.RdvRepresentation;
import micro.test.rdv.service.IRdvService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rdv")
@AllArgsConstructor
public class RdvController {

    private IRdvService iRdvService;

    @PostMapping("/create")
    public RdvRepresentation createRdv (@RequestBody RdvCommand rdvCommand){
        return iRdvService.createRdv(rdvCommand) ;
    }

    @GetMapping("/all")
    public List<RdvRepresentation> getAll(){
        return iRdvService.getAllRdv();
    }

    @GetMapping("/{id}")
    public RdvRepresentation getById(@PathVariable int id){
        return iRdvService.getRdvById(id);
    }

    @PutMapping("/update")
    public RdvRepresentation updateRdv (@RequestBody RdvCommand rdvCommand){
        return iRdvService.updateRdv(rdvCommand) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRdv (@PathVariable int id){
        iRdvService.deleteRdv(id); ;
    }

}
