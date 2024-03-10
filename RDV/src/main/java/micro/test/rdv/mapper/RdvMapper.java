package micro.test.rdv.mapper;

import micro.test.rdv.command.RdvCommand;
import micro.test.rdv.model.Rdv;
import micro.test.rdv.representation.RdvRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RdvMapper {

    public ModelMapper modelMapper=new ModelMapper();

public RdvMapper (){
    configureMapping();
}

    private void configureMapping() {
        modelMapper.typeMap(RdvCommand.class , Rdv.class)
                .addMappings(mapper -> {
                    mapper.map(RdvCommand::getIdCommand, Rdv::setId);
                    mapper.map(RdvCommand::getDateCommand, Rdv::setDate);
                    mapper.map(RdvCommand::getMaladeIdCommand, Rdv::setMaladeId);
                    mapper.map(RdvCommand::getMedecinIdCommand, Rdv::setMedecinId);
                    mapper.map(RdvCommand::getChambreIdCommand, Rdv::setChambreId);
                });
        modelMapper.typeMap(Rdv.class , RdvRepresentation.class)
                .addMappings(mapper -> {
                    mapper.map(Rdv::getId, RdvRepresentation::setIdRepresentation);
                    mapper.map(Rdv::getDate, RdvRepresentation::setDateRepresentation);
                    mapper.map(Rdv::getMaladeId, RdvRepresentation::setMaladeIdRepresentation);
                    mapper.map(Rdv::getMedecinId, RdvRepresentation::setMedecinIdRepresentation);
                    mapper.map(Rdv::getChambreId, RdvRepresentation::setChambreIdRepresentation);
                });
    }

    public Rdv convertCommandToEntity (RdvCommand rdvCommand){
        Rdv rdv = new Rdv();
        modelMapper.map(rdvCommand ,rdv);
        return rdv;
    }

    public RdvRepresentation convertEntityToRepresentation (Rdv rdv){
        RdvRepresentation rdvRepresentation = new RdvRepresentation();
        modelMapper.map(rdv ,rdvRepresentation);
        return rdvRepresentation;
    }

    public List<RdvRepresentation> convertListEntityToListRepresentation (List<Rdv> rdvs){
        List<RdvRepresentation> rdvsRepresentation = new ArrayList<>();
        for (Rdv rdv : rdvs) {
            RdvRepresentation rdvRep = modelMapper.map(rdv, RdvRepresentation.class);
            rdvsRepresentation.add(rdvRep);
        }
        return rdvsRepresentation;
    }



}
