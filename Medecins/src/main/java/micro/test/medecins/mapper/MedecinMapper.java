package micro.test.medecins.mapper;

import micro.test.medecins.command.MedecinCommand;
import micro.test.medecins.model.Medecin;
import micro.test.medecins.representation.MedecinRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedecinMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public MedecinMapper (){
        configureMapping();
    }

    private void configureMapping() {
        modelMapper.typeMap(MedecinCommand.class , Medecin.class)
                .addMappings(mapper -> {
                    mapper.map(MedecinCommand::getIdCommand, Medecin::setId);
                    mapper.map(MedecinCommand::getNomCommand, Medecin::setNom);
                    mapper.map(MedecinCommand::getPrenomCommand, Medecin::setPrenom);
                    mapper.map(MedecinCommand::getEmailCommand, Medecin::setEmail);
                    mapper.map(MedecinCommand::getUsernameCommand, Medecin::setUsername);
                });
        modelMapper.typeMap(Medecin.class , MedecinRepresentation.class)
                .addMappings(mapper -> {
                    mapper.map(Medecin::getId, MedecinRepresentation::setIdRepresentation);
                    mapper.map(Medecin::getNom, MedecinRepresentation::setNomRepresentation);
                    mapper.map(Medecin::getPrenom, MedecinRepresentation::setPrenomRepresentation);
                    mapper.map(Medecin::getEmail, MedecinRepresentation::setEmailRepresentation);
                    mapper.map(Medecin::getUsername, MedecinRepresentation::setUsernameRepresentation);
                });
    }

    public Medecin convertCommandToEntity (MedecinCommand medecinCommand){
         Medecin medecin = new Medecin();
         modelMapper.map(medecinCommand ,medecin);
         return medecin;
     }

    public MedecinRepresentation convertEntityToRepresentation (Medecin medecin){
        MedecinRepresentation medecinRepresentation = new MedecinRepresentation();
        modelMapper.map(medecin ,medecinRepresentation);
        return medecinRepresentation;
    }

    public List<MedecinRepresentation> convertListEntityToListRepresentation (List<Medecin> medecins){
        List<MedecinRepresentation> medecinsRepresentation = new ArrayList<>();
        for (Medecin medecin : medecins) {
            MedecinRepresentation medecinRep = modelMapper.map(medecin, MedecinRepresentation.class);
            medecinsRepresentation.add(medecinRep);
        }
        return medecinsRepresentation;
    }


}
