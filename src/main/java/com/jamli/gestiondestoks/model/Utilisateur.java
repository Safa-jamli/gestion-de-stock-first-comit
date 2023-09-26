package com.jamli.gestiondestoks.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Getter
 @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "utilisateur")
@ToString
public class Utilisateur extends  AbstractEntity{
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "datedenaissance")
    private String dateDeNaissance;

    @Column(name = "motdepasse")
    private String moteDePasse;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;


}
