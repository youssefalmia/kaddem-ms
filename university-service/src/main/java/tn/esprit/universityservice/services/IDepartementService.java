package tn.esprit.universityservice.services;

import org.springframework.stereotype.*;
import tn.esprit.universityservice.entities.*;
import tn.esprit.universityservice.model.*;

import java.util.*;

@Service
public interface IDepartementService {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement(Departement d) ;
    Departement updateDepartement (Departement d);
    Departement retrieveDepartement (Integer idDepart);

    Departement affecterEtudiant(Integer idDep, Integer idEtudiant) ;

    Departement retrieveDepartementByName(String nomDep);

    List<Etudiant> getDepartmentEtudiant(String nomDep);
}
