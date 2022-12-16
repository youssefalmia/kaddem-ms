package tn.esprit.etudiantservice.repositories;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.services.feinServices.*;

import java.util.*;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant, Integer> {

    List<Etudiant> findByPrenomNotNull() ;

    List<Etudiant> getEtudiantsByDepartementId(Integer departementId);

    @Query("select e from Etudiant e inner join e.contrats contrat where contrat.dateDebutContrat = ?1")
    List<Etudiant> findByContrat_DateDebutcontrat(Date dateDebutcontrat);


    //@Query("select e from Etudiant e inner join e.departementId ee where ee.nomDepart = ?1")
    //List<Etudiant> findEtudiantByDepartement(String nomDep);

    @Query("select e from Etudiant e where e.prenom = ?1 and e.nom = ?2")
    List<Etudiant> findEtudiantByPrenomEtNom(String prenomE, String nomE);


    //@Query("select e from Etudiant e inner join e.departement ee where ee.idDepart = ?1")
    //List<Etudiant> getEtudiantsByDepartement(Integer IdDep);
}
