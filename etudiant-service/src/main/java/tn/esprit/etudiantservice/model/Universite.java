package tn.esprit.etudiantservice.model;

import lombok.*;


import javax.persistence.*;
import java.util.*;

/**
 * @author Jozef
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Universite {

    private Integer idUniv ;
    private String nom ;
    private Set<Departement> departements;
}
