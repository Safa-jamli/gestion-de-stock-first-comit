package com.jamli.gestiondestoks.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "roles")
@ToString
public class Roles extends AbstractEntity {
    private String roleName;

//    @ManyToOne
//    @JoinColumn(name = "idutilisateur")
//    private Utilisateur utilisateur;
}
