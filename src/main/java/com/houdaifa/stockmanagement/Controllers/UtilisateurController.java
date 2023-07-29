package com.houdaifa.stockmanagement.Controllers;

import com.houdaifa.stockmanagement.Controllers.api.UtilisateurApi;
import com.houdaifa.stockmanagement.Dto.UtilisateurDto;
import com.houdaifa.stockmanagement.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UtilisateurController implements UtilisateurApi {
    @Autowired
    private com.houdaifa.stockmanagement.services.UtilisateurService UtilisateurService;

    @Override
    public UtilisateurDto save(UtilisateurDto UtilisateurDto) {
        return UtilisateurService.save(UtilisateurDto);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return UtilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        UtilisateurService.findAll();
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return UtilisateurService.findById(id);
    }


}
