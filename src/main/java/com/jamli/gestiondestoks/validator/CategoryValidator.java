package com.jamli.gestiondestoks.validator;

import com.jamli.gestiondestoks.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors =new ArrayList<>();
        if (categoryDto== null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("veuillez reinseigner le code de category");
        }
        return errors;
    }}
