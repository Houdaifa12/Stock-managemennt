package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.CommandeFournisseurDto;
import com.houdaifa.stockmanagement.Dto.CommandeFournisseurDto;
import com.houdaifa.stockmanagement.Dto.LigneCommandeFournisseurDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Fournisseur;
import com.houdaifa.stockmanagement.model.CommandeFournisseur;
import com.houdaifa.stockmanagement.repository.ArticleRepository;
import com.houdaifa.stockmanagement.repository.FournisseurRepository;
import com.houdaifa.stockmanagement.repository.CommandeFournisseurRepository;
import com.houdaifa.stockmanagement.repository.LigneCommandeFournisseurRepository;
import com.houdaifa.stockmanagement.services.CommandeFournisseurService;
import com.houdaifa.stockmanagement.validators.LigneCommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurImpl implements CommandeFournisseurService {
    @Autowired
    private FournisseurRepository FournisseurRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommandeFournisseurRepository commandeFournisseurRepository;
    @Autowired
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if(id==null){
            log.error("the given id id null");
        }
        Optional<CommandeFournisseur> commandeFournisseur=commandeFournisseurRepository.findById(id);
        return Optional.of(CommandeFournisseurDto.fromEntity(commandeFournisseur.get())).orElseThrow(()->
                new EntityNotFoundException("the command with the id:"+id+"is not existed")
        );
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteBydId(Integer id) {
        if(id==null){
            log.error("id is null");
            return;
        }
        commandeFournisseurRepository.deleteById(id);
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        List<String>errors= (List<String>) commandeFournisseurDto.getLigneCommandeFournisseurs().stream().map(LigneCommandeFournisseurValidator::validate);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("the given command Fournisseur is not valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }
        Optional<Fournisseur> Fournisseur=FournisseurRepository.findById(commandeFournisseurDto.getFournisseur().getId());
        if(Fournisseur.isPresent()==false){
            throw  new EntityNotFoundException("this Fournisseur is not existed in the database",ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }
        List<LigneCommandeFournisseurDto>ligneCommandeFournisseurs=commandeFournisseurDto.getLigneCommandeFournisseurs();

        for(LigneCommandeFournisseurDto ligneCommandeFournisseurDto:ligneCommandeFournisseurs) {
            List<String> errors1 = LigneCommandeFournisseurValidator.validate(ligneCommandeFournisseurDto);
            if (!errors1.isEmpty()) {
                throw new InvalidEntityException("invalid command line", ErrorCodes.LIGNE_COMMANDE_CLIENT_NOT_VALID, errors1);
            }
            if (articleRepository.findArticleByCodeArticle(ligneCommandeFournisseurDto.getArticle().getCodeArticle()) == null) {
                throw new EntityNotFoundException("the article is not found in the database", ErrorCodes.ARTICLE_NOT_FOUND);
            }
        }
        return CommandeFournisseurDto.fromEntity(commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto)));

    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(code==null){
            log.error("the given code is null");
        }
        Optional<CommandeFournisseur> commandeFournisseur=commandeFournisseurRepository.findByCode(code);
        return Optional.of(CommandeFournisseurDto.fromEntity(commandeFournisseur.get())).orElseThrow(()->
                new EntityNotFoundException("the command with the code:"+code+"is not existed")
        );
    }
}
