package tn.esprit.etudiantservice.services;

import org.springframework.stereotype.*;
import tn.esprit.etudiantservice.entities.*;

import java.util.*;
@Service
public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e) ;
    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);

    void faireEvoluerEquipes();
}
