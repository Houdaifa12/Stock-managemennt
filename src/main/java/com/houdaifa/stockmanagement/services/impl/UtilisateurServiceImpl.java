package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.EntrepriseDto;
import com.houdaifa.stockmanagement.Dto.FournisseurDto;
import com.houdaifa.stockmanagement.Dto.UtilisateurDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Fournisseur;
import com.houdaifa.stockmanagement.model.Utilisateur;
import com.houdaifa.stockmanagement.repository.UtilisateurRepository;
import com.houdaifa.stockmanagement.services.UtilisateurService;
import com.houdaifa.stockmanagement.validators.FournisseurValidator;
import com.houdaifa.stockmanagement.validators.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String>errors= UtilisateurValidator.validate(utilisateurDto);
        if(!errors.isEmpty()){
            log.error("User Not valid ",utilisateurDto);
            throw new InvalidEntityException("The given User is not valid", ErrorCodes.CLIENT_NOT_VALID,errors);
        }

        return utilisateurDto.fromEntity(utilisateurRepository.save(utilisateurDto.toEntity(utilisateurDto)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return null;
        }
        Optional<Utilisateur> utilisateur=utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()->
                new EntityNotFoundException("The User with the id:"+id+"is not existed", ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public void deleteById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll()
                .stream().map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }
}
