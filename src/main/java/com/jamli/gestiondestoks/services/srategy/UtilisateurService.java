package com.jamli.gestiondestoks.services.srategy;

import com.jamli.gestiondestoks.dto.FournisseurDto;
import com.jamli.gestiondestoks.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);





}
