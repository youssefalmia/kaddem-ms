package tn.esprit.etudiantservice.controllers;

import lombok.*;
import org.springframework.format.annotation.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.services.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {

    private final IContratService iContratService;
    private final IEtudiantService iEtudiantService;
    @GetMapping("/all")
    @ResponseBody
    public List<Contrat> getContrat(){
        return iContratService.retrieveAllContrats();
    }
    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat contrat){
        return iContratService.addContrat(contrat);
    }
    @PutMapping ("/update")
    public Contrat updateContrat(@RequestBody Contrat contrat){
        return iContratService.updateContrat(contrat);
    }
    @GetMapping("/get/{id-contrat}")
    public Contrat getById(@PathVariable("id-contrat") Integer id){
        return iContratService.retrieveContrat(id);
    }
    @DeleteMapping("/remove/{id-contrat}")
    public void removeContrat(@PathVariable("id-contrat")Integer id){
        iContratService.removeContrat(id);
    }
    @GetMapping("/nb-contrat/{startDate}/{endDate}")
    public Integer nbContratsValides(@PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date  endDate){
        return iContratService.nbContratsValides(startDate,endDate);
    }
    @PutMapping("/{idContrat}/{idEtudiant}")
    Contrat aasignContratToEtudiant(
            @PathVariable("idContrat") Integer idContrat,
            @PathVariable("idEtudiant") Integer idEtudiant) throws Exception {
        Contrat ce = iContratService.retrieveContrat(idContrat);
        Etudiant etudiant = iEtudiantService.getEtudiantById(idEtudiant);
        return iContratService.affectContratToEtudiant(ce, etudiant.getNom(), etudiant.getPrenom());
    }
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{start}/{end}")
    float getChiffreAffaireEntreDeuxDate(@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return iContratService.getChiffreAffaireEntreDeuxDate(start,end);
    }
    @GetMapping("/contratBetween2dates/{start}/{end}")
    List<Contrat> contratBetween2dates(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return iContratService.contratBetween2dates(start,end);
    }
}
