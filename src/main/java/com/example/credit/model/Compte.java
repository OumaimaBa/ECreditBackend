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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dateOuverture;
    private String chapitre;
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Document> documents;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToOne(mappedBy = "compte", cascade = CascadeType.ALL)
    @JsonManagedReference
    protected DossierCredit dc;
}
