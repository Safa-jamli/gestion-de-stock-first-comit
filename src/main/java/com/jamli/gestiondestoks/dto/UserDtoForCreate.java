package com.jamli.gestiondestoks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoForCreate {
    private String nom;
    private String prenom;
    private String email;
    private Instant dateDeNaissance;
    private String moteDePasse;
    private AdresseDto adresse;
}
