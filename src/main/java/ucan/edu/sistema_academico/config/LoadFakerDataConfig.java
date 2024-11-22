package ucan.edu.sistema_academico.config;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import ucan.edu.sistema_academico.entities.Estudante;
import ucan.edu.sistema_academico.repositories.EstudanteRepository;

@Configuration
@DependsOn("loadJsonFilesConfig")
public class LoadFakerDataConfig {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Bean
    public CommandLineRunner startEstudantes() {
        return args -> {
            cadastrarEstudantes();
        };
    }

    // Método para cadastrar estudantes fictícios
    private void cadastrarEstudantes() {
        Faker faker = new Faker();
        for (int i = 0; i < 1000; i++) {
            Estudante estudante = new Estudante();
            estudante.setNumeroEstudante("10000" + faker.number().digits(5));
            estudante.setNome(faker.name().fullName());
            estudanteRepository.save(estudante);
        }
        System.out.println("Estudantes salvos com sucesso!");
    }
}
