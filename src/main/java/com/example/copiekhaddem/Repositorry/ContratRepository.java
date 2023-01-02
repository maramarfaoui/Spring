package com.example.copiekhaddem.Repositorry;

import com.example.copiekhaddem.Entities.Contrat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {
}
