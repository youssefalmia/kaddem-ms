package tn.esprit.etudiantservice.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import tn.esprit.etudiantservice.entities.*;

import java.util.*;

@Repository
public interface IContratRepository extends CrudRepository<Contrat, Integer> {
    @Query("select count (c) from Contrat c where c.dateDebutContrat >= ?1 and c.dateFinContrat <= ?2 and c.archive=true")
    Integer nbContratsValides(Date startDate, Date endDate);

    @Query("select count (c) from Contrat c where c.etudiant.idEtudiant = ?1 ")
    Integer nbContratsEtudiant(Integer etID);
    @Query("select  SUM(c.montantContrat) from Contrat c where c.dateFinContrat<=?2 and c.dateDebutContrat>=?1")
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    @Query("select c from Contrat c where   c.dateDebutContrat>=?1 and c.dateFinContrat<=?2")
    List<Contrat> contratBetween2dates(Date startDate, Date endDate);

}
