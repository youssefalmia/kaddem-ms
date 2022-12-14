package tn.esprit.universityservice.controllers;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.universityservice.entities.*;
import tn.esprit.universityservice.services.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    private  final IUniversiteService iUniversiteService;
    @GetMapping("/all")
    @ResponseBody
    public List<Universite> getAllUni(){
        return iUniversiteService.retrieveAllUniversites();
    }
    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite){
        return iUniversiteService.addUniversite(universite);
    }

    @PostMapping("/addWithDep")
    public Universite addUniversiteWithDep(@RequestBody Universite universite) throws Exception {
        Set<Departement> departementSet = new HashSet<>(universite.getDepartements());
        if(departementSet.isEmpty()){
            throw new Exception("can't add universite with emty deps");
        }
        return iUniversiteService.addUniversiteWithDepartement(universite,departementSet);
    }

    @PutMapping ("/update")
    public Universite updateUni(@RequestBody Universite universite){
        return iUniversiteService.updateUniversite(universite);
    }
    @GetMapping("/get/{id-uni}")
    public Universite getById(@PathVariable("id-uni")Integer id){
        return iUniversiteService.retrieveUniversite(id);

    }
    @PutMapping("/assign/{idUniv}/{idDepart}")
    void assignUniversiteToDepartement(@PathVariable("idUniv") Integer idUniv, @PathVariable("idDepart") Integer idDep){
        iUniversiteService.assignUniversiteToDepartement(idUniv, idDep);
    }
    @GetMapping("/getDep/{idUniv}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniv") Integer idUniversite)
    {
        return iUniversiteService.retrieveDepartementsByUniversite(idUniversite);
    }
}
