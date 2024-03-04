package micro.test.authentication.controller;

import lombok.AllArgsConstructor;
import micro.test.authentication.entities.Produit;
import micro.test.authentication.repository.IProduitRepository;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class AuthController {

    private IProduitRepository iProduitRepository;



    @GetMapping("/")
    public String home () {
        return "home";
    }

    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }


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


}

