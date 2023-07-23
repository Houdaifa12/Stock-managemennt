package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto findById(Integer id);

    List<CommandeClientDto>findAll();
    void deleteBydId(Integer id);

    CommandeClientDto save(CommandeClientDto commandeClientDto);
    CommandeClientDto findByCode(String code);


}
