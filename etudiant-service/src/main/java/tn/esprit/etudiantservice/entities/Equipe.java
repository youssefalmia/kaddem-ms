package tn.esprit.etudiantservice.entities;

import lombok.*;
import tn.esprit.etudiantservice.enums.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Getter
@Setter @AllArgsConstructor
@NoArgsConstructor
public class Equipe  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe ;
    private String nomEquipe ;

    @Enumerated(EnumType.STRING)
    private Niveau niveau ;

    @ManyToMany(mappedBy = "equipes", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Etudiant> etudiants ;

    @OneToOne
    private DetailEquipe detailEquipe ;
}
