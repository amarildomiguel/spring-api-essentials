package ucan.edu.sg_acad.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
