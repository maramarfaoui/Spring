package com.example.copiekhaddem.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Integer idContrat; // Clé primaire
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite ;
    private Boolean archive;
    private Integer montantContrat;
    @ManyToOne
    Etudiant etudiant ;


}
