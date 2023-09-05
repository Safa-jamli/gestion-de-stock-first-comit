package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.controller.api.FournisseurApi;
import com.jamli.gestiondestoks.dto.FournisseurDto;
import com.jamli.gestiondestoks.services.srategy.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;
    @Autowired
    public FournisseurController(FournisseurService fournisseurService){

        this.fournisseurService=fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {

        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer id) {

        return  fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {

        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {

        fournisseurService.delete(id);
    }
}
