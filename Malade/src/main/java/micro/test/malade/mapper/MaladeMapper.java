package micro.test.malade.mapper;

import micro.test.malade.command.MaladeCommand;
import micro.test.malade.model.Malade;
import micro.test.malade.representation.MaladeRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaladeMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public MaladeMapper (){
        configureMapping();
    }

    private void configureMapping() {
        modelMapper.typeMap(MaladeCommand.class , Malade.class)
                .addMappings(mapper -> {
                    mapper.map(MaladeCommand::getIdCommand, Malade::setId);
                    mapper.map(MaladeCommand::getNomCommand, Malade::setNom);
                    mapper.map(MaladeCommand::getPrenomCommand, Malade::setPrenom);
                    mapper.map(MaladeCommand::getEmailCommand, Malade::setEmail);
                    mapper.map(MaladeCommand::getUsernameCommand, Malade::setUsername);
                    mapper.map(MaladeCommand::getChambreIdCommand, Malade::setChambreId);

                });
        modelMapper.typeMap(Malade.class , MaladeRepresentation.class)
                .addMappings(mapper -> {
                    mapper.map(Malade::getId, MaladeRepresentation::setIdRepresentation);
                    mapper.map(Malade::getNom, MaladeRepresentation::setNomRepresentation);
                    mapper.map(Malade::getPrenom, MaladeRepresentation::setPrenomRepresentation);
                    mapper.map(Malade::getEmail, MaladeRepresentation::setEmailRepresentation);
                    mapper.map(Malade::getUsername, MaladeRepresentation::setUsernameRepresentation);
                    mapper.map(Malade::getChambreId, MaladeRepresentation::setChambreIdRepresentation);

                });
    }

    public Malade convertCommandToEntity (MaladeCommand maladeCommand){
        Malade malade = new Malade();
        modelMapper.map(maladeCommand ,malade);
        return malade;
    }

    public MaladeRepresentation convertEntityToRepresentation (Malade malade){
        MaladeRepresentation maladeRepresentation = new MaladeRepresentation();
        modelMapper.map(malade ,maladeRepresentation);
        return maladeRepresentation;
    }

    public List<MaladeRepresentation> convertListEntityToListRepresentation (List<Malade> malades){
        List<MaladeRepresentation> maladesRepresentation = new ArrayList<>();
        for (Malade malade : malades) {
            MaladeRepresentation maladeRep = modelMapper.map(malade, MaladeRepresentation.class);
            maladesRepresentation.add(maladeRep);
        }
        return maladesRepresentation;
    }


}
