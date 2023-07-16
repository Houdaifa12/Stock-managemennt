package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto save(EntrepriseDto EntrepriseDto);
    EntrepriseDto findById(Integer id);
    EntrepriseDto findByNomEntreprise(String code);
    void deleteById(Integer id);
    List<EntrepriseDto> findAll();
}
