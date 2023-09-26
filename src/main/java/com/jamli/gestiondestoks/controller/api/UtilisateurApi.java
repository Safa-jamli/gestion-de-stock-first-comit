package com.jamli.gestiondestoks.controller.api;

import com.jamli.gestiondestoks.dto.UserDtoForCreate;
import com.jamli.gestiondestoks.dto.UtilisateurDto;
import com.jamli.gestiondestoks.model.Utilisateur;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jamli.gestiondestoks.utils.Constants.UTILISATEUR_ENDPOINT;

@Api("UTILISATEUR_ENDPOINT")
public interface UtilisateurApi {

    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    Utilisateur save(@RequestBody UserDtoForCreate dto);


    @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);

}
