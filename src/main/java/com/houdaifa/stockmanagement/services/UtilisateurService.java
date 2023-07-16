package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.RolesDto;
import com.houdaifa.stockmanagement.Dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto utilisateurDto);
    UtilisateurDto findById(Integer id);
    void deleteById(Integer id);
    List<UtilisateurDto> findAll();
}
