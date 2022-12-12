package tn.esprit.etudiantservice.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.repositories.*;

@Service
public class DetailEquipeImpl implements IDetailEquipeService{
    @Autowired
    IDetailEquipeRepository detailEquipeRepository ;
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe) {return detailEquipeRepository.save(detailEquipe);}

    @Override
    public void removeDetailEquipe(Integer idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }
}
