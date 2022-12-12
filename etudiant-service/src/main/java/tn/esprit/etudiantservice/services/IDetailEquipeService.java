package tn.esprit.etudiantservice.services;

import org.springframework.stereotype.*;
import tn.esprit.etudiantservice.entities.*;

@Service
public interface IDetailEquipeService {
    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) ;

    DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe);

    void removeDetailEquipe(Integer idDetailEquipe) ;
}
