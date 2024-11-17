package ucan.edu.sg_acad.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cursos")
public class Curso {
    @Id
    @Column(name = "pk_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkCurso;

    @Column(name = "nome", nullable = false)
    private String nome;
}
