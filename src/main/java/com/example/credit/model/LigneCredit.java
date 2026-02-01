    package com.example.credit.model;

    import java.time.LocalDate;

    import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    public class LigneCredit {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String famille;
        private String nature;
        private String type;
        private String devise;
        private int montant;
        private LocalDate dateEcheance;
        private String typetaux;
        private int taux;
        private int marge;
        private int montantcontreValeur;
        @ManyToOne
        @JoinColumn(name="id_dossier")
        @JsonBackReference
        private DossierCredit dossier;
    }
