package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.controller.api.ClientApi;
import com.jamli.gestiondestoks.dto.ClientDto;
import com.jamli.gestiondestoks.services.srategy.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService ){
        this.clientService=clientService;
    }
    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
    clientService.delete(id);
    }
}
