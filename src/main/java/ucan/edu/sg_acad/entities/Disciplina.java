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
@Entity(name = "disciplinas")
public class Disciplina {

    @Id
    @Column(name = "pkDisciplina")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkDisciplina;

    @Column(name = "nome", nullable = false)
    private String nome;

}
