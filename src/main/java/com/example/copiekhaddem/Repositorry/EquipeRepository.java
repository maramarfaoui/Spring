package com.example.copiekhaddem.Repositorry;


import com.example.copiekhaddem.Entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
}
