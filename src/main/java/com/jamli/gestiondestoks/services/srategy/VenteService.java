package com.jamli.gestiondestoks.services.srategy;

import com.jamli.gestiondestoks.dto.ClientDto;
import com.jamli.gestiondestoks.dto.VentesDto;

import java.util.List;

public interface VenteService {
    VentesDto save(VentesDto dto);

    VentesDto findById(Integer id);

    VentesDto findByCode(String code);

    List<VentesDto> findAll();

    void delete(Integer id);

}
