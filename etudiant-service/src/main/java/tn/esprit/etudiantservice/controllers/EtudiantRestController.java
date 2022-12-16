package tn.esprit.etudiantservice.controllers;

import lombok.*;
import lombok.extern.slf4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.support.*;
import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.services.*;
import tn.esprit.etudiantservice.services.utils.*;

import java.util.*;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
@Slf4j
public class EtudiantRestController {

    private final IEtudiantService etudiantService ;

    private static final Logger logger = LoggerFactory.getLogger(EtudiantRestController.class);

    @Autowired
    private FileStorageService fileStorageService;

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
    @PostMapping("/add/all/fromSheet")
    public List<Etudiant> addAllEtudiantFromSheet(){
        String fileName = "E:/2022_2023_ESPRIT_4TWIN8/SpringAngularProject/0_microservice/etudiant-service/src/main/resources/assets/tsypParticipant.xlsx";
        return etudiantService.addAllEtudiantFromSheet(fileName);
    }


    @PostMapping("/uploadFromFile")
    public List<Etudiant> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        return etudiantService.addAllEtudiantFromSheet(fileName);
    }



}
