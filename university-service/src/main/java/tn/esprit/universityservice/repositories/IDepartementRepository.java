package tn.esprit.universityservice.repositories;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import tn.esprit.universityservice.entities.*;

@Repository
public interface IDepartementRepository extends CrudRepository<Departement, Integer> {

    Departement findFirstByNomDepart(String nomDep);

}
