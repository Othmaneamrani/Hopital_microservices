package micro.test.malade.controller;

import lombok.AllArgsConstructor;
import micro.test.malade.command.MaladeCommand;
import micro.test.malade.representation.MaladeRepresentation;
import micro.test.malade.service.IMaladeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("malade")
@AllArgsConstructor
public class MaladeController {

    private IMaladeService iMaladeService ;

    @PostMapping("/create")
    public MaladeRepresentation createMalade (@RequestBody MaladeCommand maladeCommand){
        return iMaladeService.createMalade(maladeCommand) ;
    }

    @GetMapping("/all")
    public List<MaladeRepresentation> getAll(){
        return iMaladeService.getAllMalade();
    }

    @GetMapping("/{id}")
    public MaladeRepresentation getById(@PathVariable int id){
        return iMaladeService.getMaladeById(id);
    }

    @PutMapping("/update")
    public MaladeRepresentation updateMalade (@RequestBody MaladeCommand maladeCommand){
        return iMaladeService.updateMalade(maladeCommand) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMalade (@PathVariable int id){
        iMaladeService.deleteMalade(id); ;
    }

}
