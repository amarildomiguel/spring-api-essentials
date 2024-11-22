package ucan.edu.sistema_academico.config;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import ucan.edu.sistema_academico.entities.Desporto;
import ucan.edu.sistema_academico.entities.Estudante;
import ucan.edu.sistema_academico.entities.Localidade;
import ucan.edu.sistema_academico.repositories.EstudanteRepository;
import ucan.edu.sistema_academico.services.DesportoService;
import ucan.edu.sistema_academico.services.LocalidadeService;
import ucan.edu.sistema_academico.utils.DataUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@DependsOn("loadJsonFilesConfig")
public class LoadFakerDataConfig {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private DesportoService desportoService;

    private @Autowired LocalidadeService localidadeService;

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
            LocalDate dataNascimento = DataUtils.escolherAleatoriamenteDataNascimento(20, 60);

            // Escolher localidades aleatórias para trabalho e residência
            Localidade localTrabalho = localidadeService.escolherAleatoriamenteLocalidadeAngolana();
            Localidade localResidencia = localidadeService.escolherAleatoriamenteLocalidadeAngolana();

            List<Desporto> desportos = new ArrayList<>();
            int quantidadeEsportes = new Random().nextInt(3) + 1; // 1 a 3 esportes

            for (int j = 0; j < quantidadeEsportes; j++) {
                Desporto desportoAleatorio;

                do {
                    desportoAleatorio = desportoService.escolherAleatoriamenteDesporto();
                } while (desportos.contains(desportoAleatorio)); // Evita duplicatas

                desportos.add(desportoAleatorio);
            }

            Estudante estudante = new Estudante();
            estudante.setNumeroEstudante("10000" + faker.number().digits(5));
            estudante.setNome(faker.name().fullName());
            estudante.setDataDeNascimento(dataNascimento);
            estudante.setLocalResidencia(localResidencia);
            estudante.setLocalTrabalho(localTrabalho);
            estudante.setDesportosPracticados(desportos);
            estudanteRepository.save(estudante);
        }
        System.out.println("Estudantes salvos com sucesso!");
    }
}
