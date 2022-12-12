package tn.esprit.universityservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Getter
@Setter @AllArgsConstructor
@NoArgsConstructor
public class Universite  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniv ;
    private String nom ;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universite")
    private Set<Departement> departements;
}
