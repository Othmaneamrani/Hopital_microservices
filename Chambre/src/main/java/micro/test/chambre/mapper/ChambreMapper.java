package micro.test.chambre.mapper;

import micro.test.chambre.command.ChambreCommand;
import micro.test.chambre.model.Chambre;
import micro.test.chambre.representation.ChambreRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChambreMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public ChambreMapper(){
        configureMappings();
    }

    private void configureMappings() {
        modelMapper.typeMap(ChambreCommand.class , Chambre.class)
                .addMappings(mapper -> {
                    mapper.map(ChambreCommand::getIdCommand , Chambre::setId);
                    mapper.map(ChambreCommand::getEtageCommand , Chambre::setEtage);
                    mapper.map(ChambreCommand::getTailleCommand , Chambre::setTaille);
                    mapper.map(ChambreCommand::getCapaciteCommand , Chambre::setCapacite);
                    mapper.map(ChambreCommand::getUtiliseCommand , Chambre::setUtilise);
                    mapper.map(ChambreCommand::getDispoCommand , Chambre::setDispo);
                        });

        modelMapper.typeMap(Chambre.class , ChambreRepresentation.class)
                .addMappings(mapper -> {
                    mapper.map(Chambre::getId , ChambreRepresentation::setIdRepresentation);
                    mapper.map(Chambre::getEtage , ChambreRepresentation::setEtageRepresentation);
                    mapper.map(Chambre::getTaille , ChambreRepresentation::setTailleRepresentation);
                    mapper.map(Chambre::getCapacite , ChambreRepresentation::setCapaciteRepresentation);
                    mapper.map(Chambre::getUtilise , ChambreRepresentation::setUtiliseRepresentation);
                    mapper.map(Chambre::getDispo , ChambreRepresentation::setDispoRepresentation);
                });
    }

    public Chambre convertCommandToEntity (ChambreCommand chambreCommand){
        Chambre chambre = new Chambre();
        modelMapper.map(chambreCommand ,chambre);
        return chambre;
    }

    public ChambreRepresentation convertEntityToRepresentation (Chambre chambre){
        ChambreRepresentation chambreRepresentation = new ChambreRepresentation();
        modelMapper.map(chambre ,chambreRepresentation);
        return chambreRepresentation;
    }

    public List<ChambreRepresentation> convertListEntityToListRepresentation (List<Chambre> chambres){
        List<ChambreRepresentation> chambresRepresentation = new ArrayList<>();
        for (Chambre chambre : chambres) {
            ChambreRepresentation chambreRep = modelMapper.map(chambre, ChambreRepresentation.class);
            chambresRepresentation.add(chambreRep);
        }
        return chambresRepresentation;
    }


}
