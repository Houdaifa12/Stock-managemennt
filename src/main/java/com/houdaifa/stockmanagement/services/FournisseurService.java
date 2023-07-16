package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.EntrepriseDto;
import com.houdaifa.stockmanagement.Dto.FournisseurDto;
import com.houdaifa.stockmanagement.model.Fournisseur;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto fournisseurDto);
    FournisseurDto findById(Integer id);
    FournisseurDto findByNomFournisseur(String nom);
    void deleteById(Integer id);
    List<FournisseurDto> findAll();
}
