package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.CommandeClientDto;
import com.houdaifa.stockmanagement.Dto.LigneCommandeClientDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.CommandeClient;
import com.houdaifa.stockmanagement.repository.CommandeClientRepository;
import com.houdaifa.stockmanagement.services.CommandeClientService;
import com.houdaifa.stockmanagement.validators.CommandeClientValidator;
import com.houdaifa.stockmanagement.validators.LigneCommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {
    @Autowired
    private CommandeClientRepository commandeClientRepository;
    @Override
    public CommandeClientDto findById(Integer id) {
        if(id==null){
            log.error("article id id invalid",id);
            return null;
        }
        Optional<CommandeClient> commandeClients=commandeClientRepository.findById(id);
        return Optional.of(CommandeClientDto.fromEntity(commandeClients.get())).orElseThrow(
                ()->new EntityNotFoundException("not found Command line ",ErrorCodes.COMMANDE_CLIENT_NOT_FOUND)


        );

    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteBydId(Integer id) {
        if(id==null){
            log.error("id is null");
            return;
        }
      commandeClientRepository.deleteById(id);
    }

    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        List<String>errors=new ArrayList<>();
        for(LigneCommandeClientDto ligneCommandeClientDto:commandeClientDto.getLigneCommandeClients()) {
            errors.add(LigneCommandeClientValidator.validate(ligneCommandeClientDto).toString());
        }
       List<String>errors1= (List<String>) commandeClientDto.getLigneCommandeClients().stream().map(LigneCommandeClientValidator::validate);
        if(!errors1.isEmpty()){
            throw new InvalidEntityException("invalid Command Line Try again", ErrorCodes.LIGNE_COMMANDE_CLIENT_NOT_VALID,errors1);
        }
        return CommandeClientDto.fromEntity(commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto)));

    }
}
