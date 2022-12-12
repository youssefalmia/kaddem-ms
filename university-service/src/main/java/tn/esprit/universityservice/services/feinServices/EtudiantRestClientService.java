package tn.esprit.universityservice.services.feinServices;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.universityservice.model.*;

import java.util.*;

/**
 * @author Jozef
 */
@FeignClient(name = "etudiant-service")
public interface EtudiantRestClientService {
    @GetMapping("/etudiant/get/{idEtu}")
    public Etudiant retrieveEtudiant(@PathVariable Integer idEtu);

    @GetMapping("/etudiant/all")
    public List<Etudiant> findAll();

    @PutMapping("/etudiant/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e);

}
