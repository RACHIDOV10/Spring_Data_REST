package com.example.DataREST;

import com.example.DataREST.entities.Client;
import com.example.DataREST.entities.Compte;
import com.example.DataREST.entities.TypeCompte;
import com.example.DataREST.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.DataREST.repositories.CompteRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class DataRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataRestApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);

            Client c1 = clientRepository.save(new Client(null, "Amal", "amal@gmail.com", null));
            Client c2 = clientRepository.save(new Client(null,"Ali", "ali@gmail.com", null));

            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            compteRepository.findAll().forEach(c -> {
                System.out.println("Compte ID: " + c.getId() +
                        ", Solde: " + c.getSolde() +
                        ", Client: " + c.getClient().getNom());
            });
        };
    }
}