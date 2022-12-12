package tn.esprit.universityservice.controllers;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.universityservice.entities.*;
import tn.esprit.universityservice.model.*;
import tn.esprit.universityservice.services.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dep")
public class DepartementRestController {
    private final IDepartementService iDepartementService;
    @GetMapping("/get/{id-dep}")

    public Departement getById(@PathVariable("id-dep") Integer id){
        return iDepartementService.retrieveDepartement(id);
    }

    @GetMapping("/getByNom/{nomDep}")
    public Departement getByNomDep(@PathVariable("nomDep") String nomDep){
        return iDepartementService.retrieveDepartementByName(nomDep);
    }

    @GetMapping("/getEtudByNom/{nomDep}")
    public List<Etudiant> getDepartmentEtudiant(@PathVariable("nomDep") String nomDep){
        return iDepartementService.getDepartmentEtudiant(nomDep);
    }

    @PostMapping("/add")
    public Departement addDepart(@RequestBody Departement dep){
        return  iDepartementService.addDepartement(dep);
    }
    @GetMapping("/all")
    @ResponseBody
    public List<Departement> getDepart() {
        return iDepartementService.retrieveAllDepartements();
    }
    @PutMapping("/update")
    public Departement Departementupdate(@RequestBody Departement departement){
        return iDepartementService.updateDepartement(departement);
    }

    @PutMapping("/etudiantToDep/{idDep}/{idEt}")
    public Departement assignEtudiantToDepartement(@PathVariable("idDep") Integer idDep, @PathVariable("idEt") Integer idEt){
        return iDepartementService.affecterEtudiant(idDep,idEt);

    }

}
