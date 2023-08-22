package com.jamli.gestiondestoks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "commandeclient")
public class CommandeClient extends AbstractEntity {
    @Column(name= "code")
    private String code;

    @Column(name= "datecommande")
    private Instant DateCommande;

    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;


    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> lignescommadeclients;


}
