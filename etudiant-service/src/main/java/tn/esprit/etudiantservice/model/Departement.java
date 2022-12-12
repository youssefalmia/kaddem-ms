package tn.esprit.etudiantservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import tn.esprit.etudiantservice.entities.*;


import javax.persistence.*;
import java.util.*;

/**
 * @author Jozef
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Departement {

    private Integer idDepart ;
    private String nomDepart ;

    @JsonIgnore
    Universite universite;
    @JsonIgnore
    private Set<Etudiant> etudiants ;

}
