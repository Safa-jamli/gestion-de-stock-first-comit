package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.controller.api.VentesApi;
import com.jamli.gestiondestoks.dto.VentesDto;
import com.jamli.gestiondestoks.services.srategy.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentesController implements VentesApi {

    private VenteService venteService;
    @Autowired
    public VentesController(VenteService venteService){

        this.venteService=venteService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        return venteService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {

        return  venteService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {

        return venteService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {

        return venteService.findAll();
    }

    @Override
    public void delete(Integer id) {
        venteService.delete(id);
    }
}
