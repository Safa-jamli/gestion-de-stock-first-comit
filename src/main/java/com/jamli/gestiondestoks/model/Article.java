package com.jamli.gestiondestoks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "article")

public class Article extends AbstractEntity{
    @Column(name= "codearticle")
    private String codeArticle;

    @Column(name= "description")
    private String description;

    @Column(name= "prixunitairestva")
    private BigDecimal prixUnitairehtva;


    @Column(name= "tauxtva")
    private BigDecimal tauxTva;


    @Column(name= "prixunitairetc")
    private BigDecimal prixUnitaireTC;


    @Column(name= "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name="idcategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<MvtStock> mvtStks;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;


}