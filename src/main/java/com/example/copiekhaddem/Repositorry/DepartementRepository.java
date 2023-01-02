package com.example.copiekhaddem.Repositorry;

import com.example.copiekhaddem.Entities.Departement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository  extends JpaRepository<Departement,Integer> {
}
