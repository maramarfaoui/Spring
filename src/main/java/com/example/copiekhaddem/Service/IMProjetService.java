package com.example.copiekhaddem.Service;

import com.example.copiekhaddem.Entities.Contrat;
import com.example.copiekhaddem.Entities.Etudiant;
import com.example.copiekhaddem.Entities.Option;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface IMProjetService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
    Etudiant findEtudiantByPrenomE(String prenomE);

    List<Etudiant> retrieveEtudiantByEquipeThematique ( String thematique);

    void updateEtudiantByOption(Option option , long idEtudiant);

    public void assignEtudiantToDepartment(Integer idEtudiant, Integer idDepart);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);

    Etudiant findEtudiantByNomEAndPrenomE(String nomE,String prenomE);

    List<Etudiant> getEtudiantsByDepartement (Integer idDepart);
    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);

    List<Contrat> getContratBetweenDates(Date startDate, Date endDate);

    Integer findNbContratByDatesAndArchives(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);

    String retrieveAndUpdateStatusContrat();

}
