package ucan.edu.sistema_academico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "localidades")
public class Localidade {
    @Id
    @Column(name = "pk_localidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkLocalidade;

    @Column(name = "designacao")
    private String designacao;

    @ManyToOne
    @JoinColumn(name = "fk_localidade_pai")
    private Localidade fkLocalidadePai;

    @OneToMany(mappedBy = "fkLocalidadePai")
    @JsonIgnore
    private List<Localidade> subLocalidades;

}