package ucan.edu.sistema_academico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "precendencia")
public class Precedencia implements Serializable {

    @Id
    @Column(name = "pk_precedencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkPrecedencia;

    @OneToOne
    @JoinColumn(name = "fk_disciplina")
    private Disciplina fkDisciplina;

    @OneToOne
    @JoinColumn(name = "fk_disciplina_precedente")
    private Disciplina fkDisciplinaPrecedente;

}
