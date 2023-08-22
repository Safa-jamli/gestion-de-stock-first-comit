package com.jamli.gestiondestoks.validator;

import com.jamli.gestiondestoks.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto== null) {
            errors.add("veuillez reinseigner le code article");
            errors.add("veuillez reinseigner description d'un article");
            errors.add("veuillez reinseigner le prix unitaire  HT de l' article");
            errors.add("veuillez reinseigner le TVA de l' article");
            errors.add("veuillez selectionner category une category ");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getCodeActicle())){
            errors.add("veuillez reinseigner le code article");
        }
        if (!StringUtils.hasLength(dto.getDescription())){
            errors.add("veuillez reinseigner description d'un article");
        }
        if(dto.getPrixUnitairehtva()==null) {
            errors.add("veuillez reinseigner le prix unitaire  HT de l' article");
        }
        if(dto.getTauxTva()==null) {
            errors.add("veuillez reinseigner le TVA de l' article");
        }
        if(dto.getPrixUnitaireTC()==null) {
            errors.add("veuillez reinseigner le prix  unitaire TTC de l' article");
        }
        if(dto.getCategory()==null) {
            errors.add("veuillez selectionner category une category ");
        }
        return errors;
    }
}
