package tn.esprit.universityservice.services;

import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import tn.esprit.universityservice.entities.*;
import tn.esprit.universityservice.repositories.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UniversiteImpl implements IUniversiteService {

    @Autowired
    private final IUniversiteRepository universiteRepository;

    @Autowired
    DepartementImpl departementService;
    @Autowired
    private final IDepartementRepository departementRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite universite) {

        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniv, Integer idDep) {
        Universite univ = retrieveUniversite(idUniv);
        Departement depart = departementService.retrieveDepartement(idDep);
        depart.setUniversite(univ);
        updateUniversite(univ);
    }

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        // TODO page 18
        return universiteRepository.retrieveDepartementsByUniversite(idUniversite);
    }

    @Override
    public Universite addUniversiteWithDepartement(Universite universite, Set<Departement> departements) {

        Set<Departement> departementSet =new HashSet<>(departements);

        universite.setDepartements(departementSet);

        departementRepository.saveAll(departementSet);
        universiteRepository.save(universite);

        return universite;
    }
}
