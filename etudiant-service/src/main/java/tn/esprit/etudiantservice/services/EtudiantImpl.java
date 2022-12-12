package tn.esprit.etudiantservice.services;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.model.*;
import tn.esprit.etudiantservice.repositories.*;
import tn.esprit.etudiantservice.services.feinServices.*;

import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class EtudiantImpl implements IEtudiantService {
    @Autowired
    private final IEtudiantRepository etudiantRepository;
    @Autowired
    private final IContratRepository contratRepository;
    @Autowired
    private final IEquipeRepository equipeRepository;

    private final ContratImpl contratServices;
    private final EquipeImpl equipeServices;
    //@Autowired
    //private final IDepartementRepository departementRepository;

    @Autowired
    private final DepartementRestClientService departementRestClientService;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        log.debug("test");
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Scheduled(cron = "0 12 13 * * *")
    void test() {
        log.info("hello");
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {

        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> findEtudiantByDepartement(String nomDep) {
        return departementRestClientService.findEudDep(nomDep);
    }

    @Override
    public Etudiant getEtudiantById(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {

        Contrat ce = contratServices.retrieveContrat(idContrat);
        Equipe eq = equipeServices.retrieveEquipe(idEquipe);

        //Make an equie and contract set
        Set<Equipe> equipeSet = new HashSet<>();
        equipeSet.add(eq);

        Set<Contrat> contratSet = new HashSet<>();
        contratSet.add(ce);

        // Update the etudiant using its setters
        e.setEquipes(equipeSet);
        e.setContrats(contratSet);

        // Update the Contract
        ce.setEtudiant(e);

        Set<Etudiant> etudiantSet = new HashSet<>();
        etudiantSet.add(e);
        // update the equipe
        eq.setEtudiants(etudiantSet);

        // Start by saving the Etudiant
        etudiantRepository.save(e);
        contratServices.updateContrat(ce);
        equipeServices.updateEquipe(eq);
        return e;
    }


    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDep) {

        Departement dep = departementRestClientService.findById(idDep);
        return departementRestClientService.findEudDep(dep.getNomDepart());

    }
}
