package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.CommandeFournisseur;
import com.houdaifa.stockmanagement.model.LigneCommandeFournisseur;
import com.houdaifa.stockmanagement.model.LigneCommandeFournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LigneCommandeFournisseurDto {
    private Integer id;
    private ArticleDto article;
    private CommandeFournisseurDto commandeFournisseur;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur lIgneCommandeFournisseur){
        if(lIgneCommandeFournisseur==null){
            return null;
        }
        else{
            LigneCommandeFournisseurDto ligneCommandeFournisseurDto=new LigneCommandeFournisseurDto();
            ligneCommandeFournisseurDto.article.fromEntity(lIgneCommandeFournisseur.getArticle());
            ligneCommandeFournisseurDto.commandeFournisseur.fromEntity(lIgneCommandeFournisseur.getCommandefournisseur());
            ligneCommandeFournisseurDto.setQuantite(lIgneCommandeFournisseur.getQuantite());
            ligneCommandeFournisseurDto.setId(lIgneCommandeFournisseur.getId());
            ligneCommandeFournisseurDto.setPrixUnitaire(lIgneCommandeFournisseur.getPrixUnitaire());
            return ligneCommandeFournisseurDto;
        }
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if(ligneCommandeFournisseurDto==null){
            return null;
        }
        else{
            LigneCommandeFournisseur ligneCommandeFournisseur=new LigneCommandeFournisseur();
            ligneCommandeFournisseur.setArticle(ligneCommandeFournisseurDto.article.toEntity(ligneCommandeFournisseurDto.getArticle()));
            ligneCommandeFournisseur.setCommandefournisseur(ligneCommandeFournisseurDto.commandeFournisseur.toEntity(ligneCommandeFournisseurDto.getCommandeFournisseur()));
            ligneCommandeFournisseurDto.setQuantite(ligneCommandeFournisseur.getQuantite());
            ligneCommandeFournisseurDto.setPrixUnitaire(ligneCommandeFournisseur.getPrixUnitaire());
            return ligneCommandeFournisseur;
        }
    }
}
