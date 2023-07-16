package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto);
    ClientDto findById(Integer id);
    ClientDto findByNomClient(String code);
    void deleteById(Integer id);
    List<ClientDto> findAll();
}
