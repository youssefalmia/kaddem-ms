package tn.esprit.etudiantservice.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.*;

@Entity
@Getter
@Setter @AllArgsConstructor
@NoArgsConstructor
public class DetailEquipe  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetailEquipe ;
    private Integer salle ;
    private String thematique;

    @JsonIgnore
    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe ;
}
