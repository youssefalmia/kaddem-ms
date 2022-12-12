package tn.esprit.etudiantservice.entities;

import lombok.*;
import tn.esprit.etudiantservice.enums.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Contrat  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat ;
    @Temporal (TemporalType.DATE)
    private Date dateDebutContrat ;
    @Temporal (TemporalType.DATE)
    private Date dateFinContrat ;
    @Enumerated(EnumType.STRING)
    private Specialite specialite ;
    private Boolean archive ;
    private Integer montantContrat ;

    @ManyToOne
    Etudiant etudiant  ;

}
