package ucan.edu.sistema_academico.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Entity(name = "estudantes")
public class Estudante {

    @Id
    @Column(name = "pk_estudante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkEstudante;

    @Column(name = "numero_estudante", nullable = false)
    private String numeroEstudante;

    @OneToOne
    @JoinColumn(name = "fk_pessoa")
    private Pessoa pessoa;

}
