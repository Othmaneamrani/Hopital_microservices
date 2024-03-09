package micro.test.rdv.controller;

import lombok.AllArgsConstructor;
import micro.test.rdv.service.IRdvService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rdv")
@AllArgsConstructor
public class RdvController {

    private IRdvService iRdvService;

}
