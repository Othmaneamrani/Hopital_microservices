package micro.test.diagno.mapper;

import micro.test.diagno.command.DiagnoCommand;
import micro.test.diagno.model.Diagno;
import micro.test.diagno.representation.DiagnoRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiagnoMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public DiagnoMapper(){
        configureMappings();
    }

    private void configureMappings() {
        modelMapper.typeMap(DiagnoCommand.class , Diagno.class)
                .addMappings(mapper -> {
                    mapper.map(DiagnoCommand::getIdCommand , Diagno::setId);
                    mapper.map(DiagnoCommand::getDescriptionCommand , Diagno::setDescription);
                    mapper.map(DiagnoCommand::getMaladeIdCommand , Diagno::setMaladeId);
                    mapper.map(DiagnoCommand::getMedecinIdCommand , Diagno::setMedecinId);
                    mapper.map(DiagnoCommand::getDateCommand , Diagno::setDate);
                });

        modelMapper.typeMap(Diagno.class , DiagnoRepresentation.class)
                .addMappings(mapper -> {
                    mapper.map(Diagno::getId , DiagnoRepresentation::setIdRepresentation);
                    mapper.map(Diagno::getDescription , DiagnoRepresentation::setDescriptionRepresentation);
                    mapper.map(Diagno::getMaladeId, DiagnoRepresentation::setMaladeIdRepresentation);
                    mapper.map(Diagno::getMedecinId , DiagnoRepresentation::setMedecinIdRepresentation);
                    mapper.map(Diagno::getDate, DiagnoRepresentation::setDateRepresentation);
                });
    }

    public Diagno convertCommandToEntity (DiagnoCommand diagnoCommand){
        Diagno diagno = new Diagno();
        modelMapper.map(diagnoCommand ,diagno);
        return diagno;
    }

    public DiagnoRepresentation convertEntityToRepresentation ( Diagno diagno){
        DiagnoRepresentation diagnoRepresentation = new DiagnoRepresentation();
        modelMapper.map(diagno ,diagnoRepresentation);
        return diagnoRepresentation;
    }

    public List<DiagnoRepresentation> convertListEntityToListRepresentation (List<Diagno> diagnos){
        List<DiagnoRepresentation> diagnosRepresentation = new ArrayList<>();
        for ( Diagno diagno : diagnos) {
            DiagnoRepresentation diagnoRep = modelMapper.map(diagno, DiagnoRepresentation.class);
            diagnosRepresentation.add(diagnoRep);
        }
        return diagnosRepresentation;
    }



}
