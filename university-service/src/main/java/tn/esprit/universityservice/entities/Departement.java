package tn.esprit.universityservice.entities;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import tn.esprit.universityservice.model.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Getter
@Setter @AllArgsConstructor
@NoArgsConstructor
public class Departement  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepart ;
    private String nomDepart ;

    @JsonIgnore
    @ManyToOne
    Universite universite;

    //@JsonIgnore
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    @Transient
    @JsonIgnore
    private Set<Etudiant> etudiants ;
}
