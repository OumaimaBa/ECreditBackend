package com.example.credit.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type_client")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ClientPersonnePhysique.class, name = "p"),
    @JsonSubTypes.Type(value = ClientPersonneMorale.class, name = "m")
})
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_client")
@AllArgsConstructor
@NoArgsConstructor
public abstract class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long idRelation;
    protected String pay;
    protected String gouvernorat;
    protected String adresse;
    protected String infoComplementaires;
    protected String profession;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    protected List<Compte> comptes;
    
}
