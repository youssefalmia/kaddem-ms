package tn.esprit.universityservice.services;

import org.springframework.stereotype.*;
import tn.esprit.universityservice.entities.*;

import java.util.*;

@Service
public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite(Universite u) ;
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);

    void assignUniversiteToDepartement(Integer idUniv, Integer idDepart);
    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

    Universite addUniversiteWithDepartement(Universite universite, Set<Departement> departements);

}
