package ucan.edu.sg_acad.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ucan.edu.sg_acad.entities.Disciplina;
import ucan.edu.sg_acad.entities.Estudante;
import ucan.edu.sg_acad.entities.Pessoa;
import ucan.edu.sg_acad.repositories.DisciplinaRepository;
import ucan.edu.sg_acad.repositories.EstudanteRepository;
import ucan.edu.sg_acad.repositories.PessoaRepository;


import java.io.InputStream;
import java.util.List;

@Configuration
public class CarregarBaseDeDadosConfig {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EstudanteRepository estudanteRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Bean
    public CommandLineRunner startDB() {
        return args -> {
            CadastrarEstudantes();
            CadastrarDisciplinas();
        };
    }

void CadastrarDisciplinas() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {};
    InputStream inputStream = TypeReference.class.getResourceAsStream("/data/disciplinas.json");
    try {
        List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
        for (Disciplina disciplina : disciplinas) {
            disciplinaRepository.save(disciplina);
        }
        System.out.println("Disciplinas salvas com sucesso!");
    } catch (Exception e) {
        System.out.println("Erro ao salvar disciplinas: " + e.getMessage());
    }
}
    void CadastrarEstudantes() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        TypeReference<List<Estudante>> typeReference = new TypeReference<List<Estudante>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/estudantes.json");
        try {
            List<Estudante> estudantes = mapper.readValue(inputStream, typeReference);
            for (Estudante estudante : estudantes) {
                Pessoa pessoa = estudante.getPessoa();
                Pessoa pessoaSalva = pessoaRepository.save(pessoa);
                estudante.setPessoa(pessoaSalva);
                estudanteRepository.save(estudante);
            }
            System.out.println("Estudantes salvos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar estudantes: " + e.getMessage());
        }
    }
}