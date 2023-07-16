package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.FournisseurDto;
import com.houdaifa.stockmanagement.Dto.RolesDto;

import java.util.List;

public interface RolesService {
    RolesDto save(RolesDto rolesDto);
    RolesDto findById(Integer id);

    void deleteById(Integer id);
    List<RolesDto> findAll();
}
