package tn.esprit.etudiantservice.services.feinServices;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.model.*;

import java.util.*;

/**
 * @author Jozef
 */
@FeignClient(name = "university-service")
public interface DepartementRestClientService {
    @GetMapping("/dep/get/{idDep}")
    public Departement findById(@PathVariable Integer idDep);

    @GetMapping("/dep/getByNom/{nomDep}")
    public Departement findByNomDep(@PathVariable String nomDep);

    @GetMapping("/dep/all")
    public List<Departement> findAll();


    @GetMapping("/getEtudByNom/{nomDep}")
    public List<Etudiant> findEudDep(@PathVariable String nomDep);
}
