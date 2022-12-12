package tn.esprit.etudiantservice.controllers;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.services.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
    private final IEquipeService iEquipeService;
    private final IDetailEquipeService iDetailEquipeService;


    @GetMapping("/all")
    @ResponseBody
    public List<Equipe> getAllEquipes(){
        return  iEquipeService.retrieveAllEquipes();
    }
    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe){
        iDetailEquipeService.addDetailEquipe(equipe.getDetailEquipe());
        return  iEquipeService.addEquipe(equipe);

    }
    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe equipe){
        iDetailEquipeService.updateDetailEquipe(equipe.getDetailEquipe());
        return iEquipeService.updateEquipe(equipe);
    }
    @GetMapping("/get/{id-equipe}")
    public Equipe getById(@PathVariable("id-equipe") Integer id){
        return iEquipeService.retrieveEquipe(id);
    }

}
