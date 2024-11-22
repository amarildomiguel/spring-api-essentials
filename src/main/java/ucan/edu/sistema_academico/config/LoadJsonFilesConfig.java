package ucan.edu.sistema_academico.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import ucan.edu.sistema_academico.entities.*;
import ucan.edu.sistema_academico.repositories.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class LoadJsonFilesConfig {

    @Autowired
    private LocalidadeRepository localidadeRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private PrecendenciaRepository precendenciaRepository;
    @Autowired
    private PlanoCursoRepository planoCursoRepository;

    private ObjectMapper objectMapper;
    
    public LoadJsonFilesConfig() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Bean
    public CommandLineRunner startDB() {
        return args -> {
            carregarDados("/data/disciplinas.json", new TypeReference<List<Disciplina>>() {
            }, disciplinaRepository);
            carregarDados("/data/cursos.json", new TypeReference<List<Curso>>() {
            }, cursoRepository);
            carregarDados("/data/precedencia.json", new TypeReference<List<Precedencia>>() {
            }, precendenciaRepository);
            carregarDados("/data/planocurso.json", new TypeReference<List<PlanoCurso>>() {
            }, planoCursoRepository);
            carregarDados("/data/continentes.json", new TypeReference<List<Localidade>>() {
            }, localidadeRepository);
            carregarDados("/data/paises.json", new TypeReference<List<Localidade>>() {
            }, localidadeRepository);
            carregarDados("/data/provincias.json", new TypeReference<List<Localidade>>() {
            }, localidadeRepository);
        };
    }

    // Método genérico para carregar dados JSON
    private <T> void carregarDados(String path, TypeReference<List<T>> typeReference, JpaRepository<T, ?> repository) {
        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream(path);
            List<T> dataList = objectMapper.readValue(inputStream, typeReference);
            repository.saveAll(dataList);
            System.out.println("Dados carregados com sucesso de " + path);
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados de " + path + ": " + e.getMessage());
        }
    }


}
