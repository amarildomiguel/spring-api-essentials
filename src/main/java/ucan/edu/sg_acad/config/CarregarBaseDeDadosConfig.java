package ucan.edu.sg_acad.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ucan.edu.sg_acad.entities.Curso;
import ucan.edu.sg_acad.entities.Disciplina;
import ucan.edu.sg_acad.entities.Estudante;
import ucan.edu.sg_acad.entities.Pessoa;
import ucan.edu.sg_acad.repositories.CursoRepository;
import ucan.edu.sg_acad.repositories.DisciplinaRepository;
import ucan.edu.sg_acad.repositories.EstudanteRepository;
import ucan.edu.sg_acad.repositories.PessoaRepository;


import java.io.IOException;
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
    @Autowired
    private CursoRepository cursoRepository;

    @Bean
    public CommandLineRunner startDB() {
        return args -> {
            cadastrarEstudantes();
            cadastrarDisciplinas();
            cadastrarCursos();
        };
    }

    public void cadastrarDisciplinas() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/disciplinas.json");

        List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
        for (Disciplina disciplina : disciplinas) {
            disciplinaRepository.save(disciplina);
        }
        System.out.println("Disciplinas salvas com sucesso!");

    }

    public void cadastrarCursos() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        TypeReference<List<Curso>> typeReference = new TypeReference<List<Curso>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/cursos.json");

        List<Curso> cursos = mapper.readValue(inputStream, typeReference);
        for (Curso curso : cursos) {
            cursoRepository.save(curso);
        }
        System.out.println("Cursos salvos com sucesso!");

    }

    public void cadastrarEstudantes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        TypeReference<List<Estudante>> typeReference = new TypeReference<List<Estudante>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/estudantes.json");

        List<Estudante> estudantes = mapper.readValue(inputStream, typeReference);
        for (Estudante estudante : estudantes) {
            Pessoa pessoa = estudante.getPessoa();
            Pessoa pessoaSalva = pessoaRepository.save(pessoa);
            estudante.setPessoa(pessoaSalva);
            estudanteRepository.save(estudante);
        }
        System.out.println("Estudantes salvos com sucesso!");

    }


}