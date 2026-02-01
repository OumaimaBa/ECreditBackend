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


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Document {
    @Id
    private long id;
    private String type;
    private LocalDate date;
    private String num;
    @ManyToOne
    @JoinColumn(name = "id_compte")
    @JsonBackReference
    private Compte compte;
}
