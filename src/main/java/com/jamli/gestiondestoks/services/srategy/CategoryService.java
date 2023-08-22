package com.jamli.gestiondestoks.services.srategy;

import com.jamli.gestiondestoks.dto.ArticleDto;
import com.jamli.gestiondestoks.dto.CategoryDto;


import java.util.List;
public interface CategoryService {
   CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    void delete(Integer id);
}