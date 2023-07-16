package com.houdaifa.stockmanagement.Controllers;

import com.houdaifa.stockmanagement.Controllers.api.ClientApi;
import com.houdaifa.stockmanagement.Dto.ClientDto;
import com.houdaifa.stockmanagement.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientController implements ClientApi {
    @Autowired
    private ClientService clientService;

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.findAll();
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

   
}
