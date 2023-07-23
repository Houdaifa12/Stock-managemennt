package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.CommandeClientDto;
import com.houdaifa.stockmanagement.Dto.LigneCommandeClientDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Client;
import com.houdaifa.stockmanagement.model.CommandeClient;
import com.houdaifa.stockmanagement.model.LigneCommandeClient;
import com.houdaifa.stockmanagement.repository.ArticleRepository;
import com.houdaifa.stockmanagement.repository.ClientRepository;
import com.houdaifa.stockmanagement.repository.CommandeClientRepository;
import com.houdaifa.stockmanagement.repository.LigneCommandeClientRepository;
import com.houdaifa.stockmanagement.services.CommandeClientService;
import com.houdaifa.stockmanagement.validators.LigneCommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
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
    private ClientRepository clientRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommandeClientRepository commandeClientRepository;
    @Autowired
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Override
    public CommandeClientDto findById(Integer id) {
    if(id==null){
        log.error("the given id id null");
    }
    Optional<CommandeClient> commandeClient=commandeClientRepository.findById(id);
    return Optional.of(CommandeClientDto.fromEntity(commandeClient.get())).orElseThrow(()->
            new EntityNotFoundException("the command with the id:"+id+"is not existed")
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
    List<String>errors= (List<String>) commandeClientDto.getLigneCommandeClients().stream().map(LigneCommandeClientValidator::validate);
     if(!errors.isEmpty()){
         throw new InvalidEntityException("the given command client is not valid", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);
     }
     Optional<Client> client=clientRepository.findById(commandeClientDto.getClient().getId());
     if(client.isPresent()==false){
         throw  new EntityNotFoundException("this client is not existed in the database",ErrorCodes.CLIENT_NOT_FOUND);
     }
     List<LigneCommandeClientDto>ligneCommandeClients=commandeClientDto.getLigneCommandeClients();

     for(LigneCommandeClientDto ligneCommandeClientDto:ligneCommandeClients) {
         List<String> errors1 = LigneCommandeClientValidator.validate(ligneCommandeClientDto);
         if (!errors1.isEmpty()) {
             throw new InvalidEntityException("invalid command line", ErrorCodes.LIGNE_COMMANDE_CLIENT_NOT_VALID, errors1);
         }
         if (articleRepository.findArticleByCodeArticle(ligneCommandeClientDto.getArticle().getCodeArticle()) == null) {
             throw new EntityNotFoundException("the article is not found in the database", ErrorCodes.ARTICLE_NOT_FOUND);
         }
     }
     return CommandeClientDto.fromEntity(commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto)));

    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if(code==null){
            log.error("the given code is null");
        }
        Optional<CommandeClient> commandeClient=commandeClientRepository.findByCode(code);
        return Optional.of(CommandeClientDto.fromEntity(commandeClient.get())).orElseThrow(()->
                new EntityNotFoundException("the command with the code:"+code+"is not existed")
        );
    }
}
