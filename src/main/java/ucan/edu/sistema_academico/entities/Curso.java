package ucan.edu.sistema_academico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "cursos")
public class Curso implements Serializable {
    @Id
    @Column(name = "pk_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkCurso;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference  // para gerenciar a serialização bidirecional evitando a recursão infinita
    private List<PlanoCurso> planoCursos;
}
