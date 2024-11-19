package ucan.edu.sg_acad.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ucan.edu.sg_acad.entities.*;
import ucan.edu.sg_acad.repositories.*;


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
    @Autowired
    private PrecendenciaRepository precendenciaRepository;
    @Autowired
    private PlanoCursoRepository planoCursoRepository;

    @Bean
    public CommandLineRunner startDB() {
        return args -> {
            cadastrarEstudantes();
            cadastrarDisciplinas();
            cadastrarCursos();
            cadastrarPrecedencia();
            cadastrarPlanodeCurso();
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

    public void cadastrarPrecedencia() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        TypeReference<List<Precedencia>> typeReference = new TypeReference<List<Precedencia>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/precedencia.json");

        List<Precedencia> precedencias = mapper.readValue(inputStream, typeReference);
        for (Precedencia precedencia : precedencias) {
            precendenciaRepository.save(precedencia);
        }
        System.out.println("Precedencias salvas com sucesso!");
    }

    public void cadastrarPlanodeCurso() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        TypeReference<List<PlanoCurso>> typeReference = new TypeReference<List<PlanoCurso>>() {
        };

        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/planocurso.json");

        List<PlanoCurso> planoCursos = mapper.readValue(inputStream, typeReference);
        for (PlanoCurso planoCurso : planoCursos) {
            planoCursoRepository.save(planoCurso);
        }
        System.out.println("Plano de Curso salvo com sucesso!");
    }


}