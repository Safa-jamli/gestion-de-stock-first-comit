package com.jamli.gestiondestoks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "category")
public class Category extends AbstractEntity {

    @Column(name= "code")
    private String code;

    @Column(name= "designation")
    private String designation ;


    @OneToMany(mappedBy = "category")
    private List<Article> articles;

    @Column(name = "identreprise")
    private Integer idEntreprise;
}