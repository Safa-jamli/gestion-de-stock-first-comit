package com.jamli.gestiondestoks.services.srategy;

import com.jamli.gestiondestoks.dto.FournisseurDto;
import com.jamli.gestiondestoks.dto.UserDtoForCreate;
import com.jamli.gestiondestoks.dto.UtilisateurDto;
import com.jamli.gestiondestoks.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    //UtilisateurDto save(UtilisateurDto dto);

    Utilisateur save(UserDtoForCreate dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);

    UtilisateurDto findByEmail(String email);



}
