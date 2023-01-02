package com.example.copiekhaddem.Controller;

import com.example.copiekhaddem.Entities.Contrat;
import com.example.copiekhaddem.Entities.Etudiant;
import com.example.copiekhaddem.Entities.Option;
import com.example.copiekhaddem.Service.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class ProjetController {
    ProjetService projetService ;

    @GetMapping("/eee")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = projetService.retrieveAllEtudiants();
        return listEtudiants;
    }
    @GetMapping("/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Integer idEtudiant) {
        return projetService.retrieveEtudiant(idEtudiant);
    }

    @PostMapping("")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = projetService.addEtudiant(e);
        return etudiant;
    }

    @DeleteMapping("/{idEtudiant}")
    public void removeOperateur(@PathVariable("idEtudiant") Integer idEtudiant) {
        projetService.removeEtudiant(idEtudiant);
    }

    @PutMapping("")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = projetService.updateEtudiant(e);
        return etudiant;
    }

    @GetMapping("/febp/{prenomE}")
    public Etudiant findEtudiantByPrenomE(@PathVariable("prenomE") String prenomE){
        return projetService.findEtudiantByPrenomE(prenomE);
    }
    @GetMapping("/reEBET/{thematique}")
    public List<Etudiant> retrieveEtudiantByEquipeThematique(@PathVariable("thematique") String thematique) {
        return projetService.retrieveEtudiantByEquipeThematique(thematique);
    }
    @PutMapping("/updateEtudiantByOption")
    public void updateEtudiantByOption(@RequestParam("option") Option option, @RequestParam("idEtudiant") long idEtudiant) {
        projetService.updateEtudiantByOption(option,idEtudiant);
    }
    @PutMapping("/{idEtudiant}/{idDepartment}")
    public void assignEtudiantToDepartment(@PathVariable("idEtudiant") Integer idEtudiant,@PathVariable("idDepartment") Integer idDepart){
        projetService.assignEtudiantToDepartment(idEtudiant,idDepart);
    }

    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") Integer idContrat,@PathVariable("idEquipe") Integer idEquipe){
        return projetService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }


    @GetMapping("/findEtudiantByNomEAndPrenomE/{nom}/{prenom}")
    public Etudiant findEtudiantByNomEAndPrenomE(@PathVariable("nom") String nomE,@PathVariable("prenom") String prenomE){
        return projetService.findEtudiantByNomEAndPrenomE(nomE,prenomE);
    }
    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") Integer idDepart){
        return projetService.getEtudiantsByDepartement(idDepart);
    }
    @PutMapping("/affectContratToEtudiant/{nom}/{prenom}")
    public Contrat affectContratToEtudiant (@RequestBody Contrat ce, @PathVariable("nom") String nomE, @PathVariable("prenom") String prenomE){
        return projetService.affectContratToEtudiant(ce,nomE,prenomE);
    }
}
