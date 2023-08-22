package com.jamli.gestiondestoks.services.srategy;

import com.jamli.gestiondestoks.dto.CommandeClientDto;
import com.jamli.gestiondestoks.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto save(CommandeFournisseurDto dto);
    CommandeFournisseurDto findById(Integer  id);
    CommandeFournisseurDto findByCode(String code);
    List<CommandeFournisseurDto> findAll();
    void delete(Integer id);
}
