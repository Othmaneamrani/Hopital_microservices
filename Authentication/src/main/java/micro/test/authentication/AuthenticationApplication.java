package micro.test.authentication;

import micro.test.authentication.entities.Produit;
import micro.test.authentication.repository.IProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }

@Bean
    CommandLineRunner commandLineRunner (IProduitRepository iProduitRepository){
        return args ->{
            iProduitRepository.save(Produit.builder().price(10).titre("produit1").quantity(11).build());
            iProduitRepository.save(Produit.builder().price(20).titre("produit2").quantity(22).build());
            iProduitRepository.save(Produit.builder().price(30).titre("produit3").quantity(33).build());

        };
}

}


