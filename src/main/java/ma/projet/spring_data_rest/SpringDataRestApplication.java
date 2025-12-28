package ma.projet.spring_data_rest;

import ma.projet.spring_data_rest.entities.Compte;
import ma.projet.spring_data_rest.entities.TypeCompte;
import ma.projet.spring_data_rest.repositorie.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringDataRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            compteRepository.save(
                    new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, null)
            );
            compteRepository.save(
                    new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, null)
            );
            new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, null);

            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
