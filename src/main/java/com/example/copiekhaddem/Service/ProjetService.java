package com.example.copiekhaddem.Service;

import com.example.copiekhaddem.Entities.*;
import com.example.copiekhaddem.Repositorry.ContratRepository;
import com.example.copiekhaddem.Repositorry.DepartementRepository;
import com.example.copiekhaddem.Repositorry.EquipeRepository;
import com.example.copiekhaddem.Repositorry.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjetService implements IMProjetService {
    EtudiantRepository etudiantRepository ;
    DepartementRepository departementRepository ;
    ContratRepository contratRepository ;
    EquipeRepository equipeRepository ;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant) ;
    }
    @Override
    public Etudiant findEtudiantByPrenomE(String prenomE) {
        return  etudiantRepository.findByPrenomE(prenomE);
    }

    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

    @Override
    public void updateEtudiantByOption(Option option, long idEtudiant) {
        etudiantRepository.updateEtudiantByOption(option,idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartment(Integer idEtudiant, Integer idDepart) {
        Etudiant etudiant = this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement = this.departementRepository.findById(idDepart).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        contrat.setEtudiant(e);
        equipe.getEtudiant().add(e); return etudiantRepository.save(e);
    }

    @Override
    public Etudiant findEtudiantByNomEAndPrenomE(String nomE, String prenomE) {
        return etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepart) {
        Departement departement = departementRepository.findById(idDepart).orElse(null);
        List<Etudiant> etudiants = departement.getEtudiant();
        return etudiants;

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Contrat contrat = contratRepository.findById(1).orElse(null);
        /*System.out.println(nomE+prenomE);*/
        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE);
        /*if (etudiant.getContrat().size()<=5) {
            contrat.setEtudiant(etudiant);
            contratRepository.save(contrat);
        }*/
        /*ce.getIdContrat()*/
        return contrat;
    }

    @Override
    public List<Contrat> getContratBetweenDates(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public Integer findNbContratByDatesAndArchives(Date dateDebut, Date dateFin) {
        return null;
    }

    @Override
    public String retrieveAndUpdateStatusContrat() {
        return null;
    }
}
