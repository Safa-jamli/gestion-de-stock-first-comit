package com.jamli.gestiondestoks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "lignecommnadeclient")
public class LigneCommandeClient extends AbstractEntity {
    @ManyToOne
    @JoinColumn( name= "idarticle")
    private Article article;

    @Column(name= "quantite")
    private BigDecimal quantite;

    @Column(name= "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn( name= "idcommandeclient")
    private CommandeClient commandeClient;
}
