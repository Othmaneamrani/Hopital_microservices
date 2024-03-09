package micro.test.rdv.service;

import lombok.AllArgsConstructor;
import micro.test.rdv.repository.IRdvRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RdvServiceImpl implements IRdvService {

    private IRdvRepository iRdvRepository ;


}
