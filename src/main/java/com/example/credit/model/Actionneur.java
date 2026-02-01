package com.example.credit.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actionneur {
    @Id
    private String cin;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String nationalite;
    private Double capital;
    @ManyToOne
    @JoinColumn(name = "id_client")
    @JsonBackReference
    private Client client;
}
