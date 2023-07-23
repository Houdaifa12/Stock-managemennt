package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto findById(Integer id);

    List<CommandeFournisseurDto> findAll();
    void deleteBydId(Integer id);

    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);
    
    CommandeFournisseurDto findByCode(String code);
}
