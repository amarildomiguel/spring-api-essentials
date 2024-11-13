package ucan.edu.sg_acad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ucan.edu.sg_acad.entities.Pessoa;
import ucan.edu.sg_acad.repositories.PessoaRepository;


import java.util.List;

@Configuration
public class LocalConfig {

    @Autowired
    private PessoaRepository repository;

    @Bean
    public CommandLineRunner startDB() {
        return args -> {
            Pessoa p1 = new Pessoa(
                    null, "Tony Stark",
                    "00000",
                    java.time.LocalDate.parse("1999-02-24")
            );

            Pessoa p2 = new Pessoa(
                    null, "Zebedeu Andre",
                    "11111",
                    java.time.LocalDate.parse("1985-05-15")
            );

            Pessoa p3 = new Pessoa(
                    null, "Fulano de Tal",
                    "22222",
                    java.time.LocalDate.parse("1990-08-30")
            );

            repository.saveAll(List.of(p1, p2, p3));

        };
    }
}