package tn.esprit.universityservice.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import tn.esprit.universityservice.entities.*;

import java.util.*;

@Repository
public interface IUniversiteRepository extends CrudRepository<Universite, Integer> {
    @Query("select e.departements from Universite e where e.idUniv=?1")
    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
