package micro.test.authentication.controller;

import lombok.AllArgsConstructor;
import micro.test.authentication.entities.Produit;
import micro.test.authentication.repository.IProduitRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class AuthController {

    private IProduitRepository iProduitRepository;
    private ClientRegistrationRepository clientRegistrationRepository;



    @GetMapping("/")
    public String home () {
        return "home";
    }

    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/produits")
    public String produits (Model model){
        List<Produit> allProducts = iProduitRepository.findAll();
        model.addAttribute( "produits" , allProducts );
        return "produits";
    }

@GetMapping("/auth")
@ResponseBody
    public Authentication authentication (Authentication authentication){
        return authentication;
    }

    @GetMapping("/oauth2login")
    public String oauth2Login(Model model) {
        String authorizationRequestBaseUri = "oauth2/authorization";
        Map<String, String> oauth2AuthenticationUrls = new HashMap();
        Iterable<ClientRegistration> clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;;
        clientRegistrations.forEach(registration ->{
            oauth2AuthenticationUrls.put(registration.getClientName(),
                    authorizationRequestBaseUri + "/" + registration.getRegistrationId());
        });
        model.addAttribute("urls", oauth2AuthenticationUrls);
        return "oauth2Login";
    }



}

