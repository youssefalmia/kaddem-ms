package tn.esprit.etudiantservice.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import tn.esprit.etudiantservice.enums.*;
import tn.esprit.etudiantservice.model.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Getter
@Setter @AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant ;
    private String prenom ;
    private String nom ;
    @Enumerated(EnumType.STRING)
    private Option optionEtudiant ;

    //@ManyToOne(cascade = CascadeType.ALL)
    @Transient
    Departement departement;

    private Integer departementId;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "etudiant", fetch = FetchType.EAGER)
    private Set<Contrat> contrats ;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes ;
}
