package tn.esprit.etudiantservice.controllers;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.services.*;

import java.util.*;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantRestController {

    private final IEtudiantService etudiantService ;

    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant(){
       return etudiantService.retrieveAllEtudiants() ;
    }
    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant E) {
        return etudiantService.addEtudiant((E)) ;
    }


    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant E) {
        return etudiantService.updateEtudiant(E) ;
    }

    @GetMapping("/get/{id-etudiant}")
    public Etudiant getEtudiant(@PathVariable("id-etudiant") Integer idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant) ;
    }

    @DeleteMapping("/remove/{id}")
    public void removeEtudiant(@PathVariable("id") Integer idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
    @GetMapping("/get/bydep/{name}")
    public List<Etudiant> getByNamedep(@PathVariable("name") String name){
        return etudiantService.findEtudiantByDepartement(name);
    }
    @GetMapping("/get/byDep/{idDepart}")
     public List<Etudiant> getEtudiantsByDepartement (@PathVariable("idDepart") Integer idDep)
    {   //TODO page 17
        return etudiantService.getEtudiantsByDepartement(idDep);

    }
    @PutMapping("/affecter/{idContrat}/{idEquipe}")
    public void addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant E,
                                         @PathVariable("idContrat") Integer idContrat,
                                         @PathVariable("idEquipe") Integer idEquipe){
        etudiantService.addAndAssignEtudiantToEquipeAndContract(E,idContrat,idEquipe);
    }

}
