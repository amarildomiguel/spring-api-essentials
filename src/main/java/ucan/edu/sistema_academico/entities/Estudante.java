package ucan.edu.sistema_academico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "estudantes")
public class Estudante implements Serializable {

    @Id
    @Column(name = "pk_estudante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkEstudante;

    @Column(name = "numero_estudante", nullable = false)
    private String numeroEstudante;

    @Column(name = "nome", nullable = false)
    private String nome;

    private LocalDate dataDeNascimento;

    @ManyToOne
    @JoinColumn(name = "fk_local_trabalho")
    private Localidade localTrabalho;

    @ManyToOne
    @JoinColumn(name = "fk_local_residencia")
    private Localidade localResidencia;

    @ManyToMany
    @JoinTable(
            name = "estudante_desporto",
            joinColumns = @JoinColumn(name = "fk_estudante"),
            inverseJoinColumns = @JoinColumn(name = "fk_desporto")
    )
    private List<Desporto> desportosPracticados;

}
