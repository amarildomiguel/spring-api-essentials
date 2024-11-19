package ucan.edu.sg_acad.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "pessoas")
public class Pessoa {

    @Id
    @Column(name = "pk_pessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "numero_bi", nullable = false)
    private String numeroBi;

    @Column(name = "data_nascimento", nullable = true)
    private LocalDate dataNascimento;



}
