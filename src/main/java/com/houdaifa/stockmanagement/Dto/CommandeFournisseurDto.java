package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandeFournisseurDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private  FournisseurDto fournisseur;
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null) {
            return null;
        } else {
            CommandeFournisseurDto commandeFournisseurDto=new CommandeFournisseurDto();
            FournisseurDto FournisseurDto=new FournisseurDto();
            FournisseurDto.fromEntity(commandeFournisseur.getFournisseur());
            commandeFournisseurDto.setFournisseur(FournisseurDto);
            List<LigneCommandeFournisseurDto>ligneCommandeFournisseurDtos=new ArrayList<>();
            for (LigneCommandeFournisseur ligneCommandeFournisseur:commandeFournisseur.getLigneCommandeFournisseurs()){
                LigneCommandeFournisseurDto ligneCommandeFournisseurDto=new LigneCommandeFournisseurDto();
                ligneCommandeFournisseurDto.fromEntity(ligneCommandeFournisseur);
                ligneCommandeFournisseurDtos.add(ligneCommandeFournisseurDto);

            }
            commandeFournisseurDto.setLigneCommandeFournisseurs(ligneCommandeFournisseurDtos);
            commandeFournisseurDto.setId(commandeFournisseur.getId());
            commandeFournisseurDto.setDateCommande(commandeFournisseur.getDateCommande());
            commandeFournisseurDto.setCode(commandeFournisseur.getCode());
            return commandeFournisseurDto;

        }
    }
    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto==null){
            return  null;
        }
        else{
            CommandeFournisseur commandeFournisseur=new CommandeFournisseur();
            Fournisseur Fournisseur=new Fournisseur();
            Fournisseur=commandeFournisseurDto.fournisseur.toEntity(commandeFournisseurDto.getFournisseur());
            commandeFournisseur.setFournisseur(Fournisseur);
            commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
            List<LigneCommandeFournisseur>ligneCommandeFournisseurs=new ArrayList<>();
            for (LigneCommandeFournisseurDto ligneCommandeFournisseurDto:commandeFournisseurDto.getLigneCommandeFournisseurs()){
                LigneCommandeFournisseur ligneCommandeFournisseur=new LigneCommandeFournisseur();
                ligneCommandeFournisseur= ligneCommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto);
                ligneCommandeFournisseurs.add(ligneCommandeFournisseur);

            }
            commandeFournisseur.setLigneCommandeFournisseurs(ligneCommandeFournisseurs);
            commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
            commandeFournisseur.setCode(commandeFournisseur.getCode());
            return commandeFournisseur;
        }

    }
}
