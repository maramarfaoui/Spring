package com.example.copiekhaddem.Repositorry;

import com.example.copiekhaddem.Entities.Etudiant;
import com.example.copiekhaddem.Entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    Etudiant findByPrenomE(String prenomE);
    @Query("SELECT et FROM Etudiant et join et.equipe eq join eq.detailEquipe de where  de.thematique = :thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique (String thematique);


    @Modifying
    @Transactional
    @Query("update Etudiant et set et.option = :option where et.idEtudiant = :idEtudiant")
    void updateEtudiantByOption(@Param("option") Option option , @Param("idEtudiant") long idEtudiant);


    @Query("SELECT et FROM Etudiant et WHERE et.nomE=?1 and et.prenomE=?2")
    Etudiant findEtudiantByNomEAndPrenomE(String nomE,String prenomE);
}
