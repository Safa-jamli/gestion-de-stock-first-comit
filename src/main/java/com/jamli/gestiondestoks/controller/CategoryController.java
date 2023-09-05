package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.controller.api.CategoryApi;
import com.jamli.gestiondestoks.dto.CategoryDto;
import com.jamli.gestiondestoks.services.srategy.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;
    @Autowired
    public CategoryController( CategoryService categoryService){
        this.categoryService =categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Integer idCategory) {
        return categoryService.findById(idCategory);
    }

    @Override
    public CategoryDto findByCode(String codeCategory) {
        return categoryService.findByCode(codeCategory);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
     categoryService.delete(id);
    }
}
