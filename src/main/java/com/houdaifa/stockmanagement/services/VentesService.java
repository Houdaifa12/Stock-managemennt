package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.VentesDto;
import com.houdaifa.stockmanagement.Dto.VentesDto;

import java.util.List;

public interface VentesService {
    VentesDto save(VentesDto VentesDto);
    VentesDto findById(Integer id);
    void deleteById(Integer id);
    List<VentesDto> findAll();
    VentesDto findPurchaseByCode(String code);
}
