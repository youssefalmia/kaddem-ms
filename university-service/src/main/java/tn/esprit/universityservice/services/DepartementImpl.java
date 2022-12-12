package tn.esprit.universityservice.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import tn.esprit.universityservice.entities.*;
import tn.esprit.universityservice.model.*;
import tn.esprit.universityservice.repositories.*;
import tn.esprit.universityservice.services.feinServices.*;

import java.util.*;

@Service
public class DepartementImpl implements IDepartementService {
    @Autowired
    IDepartementRepository departementRepository ;

//    @Autowired
//    @Qualifier("etudiantImpl")
//    IEtudiantService etudiantService ;

    @Autowired
    EtudiantRestClientService etudiantRestClientService;


    @Override
    public List<Departement> retrieveAllDepartements() {
        return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement departement) {

        return departementRepository.save(departement) ;
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public Departement affecterEtudiant(Integer idDep, Integer idEtudiant) {
        Etudiant e = etudiantRestClientService.retrieveEtudiant(idEtudiant) ;
        Departement dep =  retrieveDepartement(idDep) ;
        e.setDepartement(dep);
        etudiantRestClientService.updateEtudiant(e) ;
        return dep ;
    }

    @Override
    public Departement retrieveDepartementByName(String nomDep) {
        return departementRepository.findFirstByNomDepart(nomDep);
    }

    @Override
    public List<Etudiant> getDepartmentEtudiant(String nomDep) {
        Departement departement = retrieveDepartementByName(nomDep);
        return (List<Etudiant>) departement.getEtudiants();
    }


}
