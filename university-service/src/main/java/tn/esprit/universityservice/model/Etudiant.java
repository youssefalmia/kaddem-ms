package tn.esprit.universityservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import tn.esprit.universityservice.entities.*;
import tn.esprit.universityservice.enums.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author Jozef
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {

    private Integer idEtudiant ;
    private String prenom ;
    private String nom ;
    private Option optionEtudiant ;
    Departement departement;
//
//    private Set<Contrat> contrats ;
//
//    private Set<Equipe> equipes ;


}
