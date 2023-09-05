package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.controller.api.UtilisateurApi;
import com.jamli.gestiondestoks.dto.UtilisateurDto;
import com.jamli.gestiondestoks.services.srategy.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {

    private UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService){

        this.utilisateurService=utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {

        return  utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {

        return utilisateurService.findById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {

        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
