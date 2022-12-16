package tn.esprit.etudiantservice.services;

import tn.esprit.etudiantservice.entities.*;
import tn.esprit.etudiantservice.services.utils.*;

import java.util.*;

/**
 * @author Jozef
 */
public class TestClass {

    public static void main(String[] args){
        List<Etudiant> etudiants = ExcelApiImpl.getListEtudiantFromSheet("E:/2022_2023_ESPRIT_4TWIN8/SpringAngularProject/0_microservice/etudiant-service/src/main/resources/assets/tsypParticipant.xlsx");
        System.out.println(etudiants);
    }
}
