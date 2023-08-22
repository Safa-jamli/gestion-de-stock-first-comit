package com.jamli.gestiondestoks.validator;

import com.jamli.gestiondestoks.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto ) {
        List<String> errors = new ArrayList<>();


        if (utilisateurDto == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("veuillez reinseigner le non d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("veuillez reinseigner le prenom  d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getMoteDePasse())) {
            errors.add("veuillez reinseigner le Moddepass d'utilisateur");
        }
        if (utilisateurDto.getDateDeNaissance() == null) {
            errors.add("veuillez reinseigner date de naissance de d'utilisateur");
        }

        if (utilisateurDto.getAdresse() == null) {
            errors.add("veuillez reinseigner l'adresse d'utilisateur");
        } else {
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
                errors.add("le champs adresse1 est obligatoir");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
                errors.add("le champs ville est obligatoir");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
                errors.add("le champs code postale  est obligatoir");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
                errors.add("le champs code Pays  est obligatoir");
            }
        }


        errors.addAll(AdresseValidator.validate(utilisateurDto.getAdresse()));
        return errors;
    }
}