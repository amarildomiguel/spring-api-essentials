package ucan.edu.sistema_academico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "precendencia")
public class Precedencia {

    @Id
    @Column(name = "pk_precedencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkPrecedencia;

    @OneToOne
    @JoinColumn(name = "fk_disciplina")
    private Disciplina fkDisciplina;

    @OneToOne
    @JoinColumn(name = "fk_disciplina_precedente")
    private Disciplina fkDisciplinaPrecedente;

}
