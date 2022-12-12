package tn.esprit.etudiantservice.services;

import org.springframework.stereotype.*;
import tn.esprit.etudiantservice.entities.*;

import java.util.*;

@Service
public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat updateContrat (Contrat ce);
    Contrat addContrat(Contrat ce) ;
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat) ;

    Integer nbContratsValides(Date startDate, Date endDate);

    Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) throws Exception;

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    List<Contrat> contratBetween2dates(Date startDate, Date endDate);

    void retrieveAndUpdateStatusContrat();
}
