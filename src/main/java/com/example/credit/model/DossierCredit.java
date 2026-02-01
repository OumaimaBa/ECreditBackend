package com.example.credit.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DossierCredit {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String status;
    private String agence;
    private String modifiePar;
    private String creePar;
    private String assigneA;
    private LocalDate dateCreation;
    private LocalDate dateModification;
    private String marche;
    @OneToMany(mappedBy = "dossier", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<LigneCredit> lignesCredit;
    @OneToOne
    @JoinColumn(name = "id_compte")
    @JsonBackReference  
    private Compte compte;
}
