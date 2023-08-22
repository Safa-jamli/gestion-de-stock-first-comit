package com.jamli.gestiondestoks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="fournisseur")
public class Fournisseur extends AbstractEntity {

    @Column(name= "nom")
    private String nom ;

    @Column(name= "prenom")
    private String prenom;

    @Embedded
    private Adresse adresse;

    @Column(name= "mail")
    private String mail;

    @Column(name= "photo")
    private String photo;

    @Column(name= "numTel")
    private String numTel;
    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
