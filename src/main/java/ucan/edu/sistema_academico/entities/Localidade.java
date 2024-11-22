package ucan.edu.sistema_academico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "localidades")
public class Localidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_localidade")
    private Integer pkLocalidade;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "fkLocalidadePai")
    @JsonIgnore
    private List<Localidade> localidadeList;

    @JoinColumn(name = "fk_localidade_pai", referencedColumnName = "pk_localidade")
    @ManyToOne
    private Localidade fkLocalidadePai;


}