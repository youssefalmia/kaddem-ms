package tn.esprit.etudiantservice.repositories;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import tn.esprit.etudiantservice.entities.*;
@Repository
public interface IEquipeRepository extends CrudRepository<Equipe, Integer> {
}
