package ucan.edu.sg_acad.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "disciplinas")
public class Disciplina {

    @Id
    @Column(name = "pk_disciplina")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkDisciplina;

    @Column(name = "nome", nullable = false)
    private String nome;

}
