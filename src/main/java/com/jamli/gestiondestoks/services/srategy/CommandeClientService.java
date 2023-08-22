package com.jamli.gestiondestoks.services.srategy;

import com.jamli.gestiondestoks.dto.ArticleDto;
import com.jamli.gestiondestoks.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto dto);
    CommandeClientDto findById(Integer  id);
    CommandeClientDto findByCode(String code);
    List<CommandeClientDto> findAll();
    void delete(Integer id);
}
