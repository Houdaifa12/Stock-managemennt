package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.LigneCommandeClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LigneCommandeClientDto {
    private Integer id;
    private ArticleDto article;
    private CommandeClientDto commandeClient;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    public static LigneCommandeClientDto fromEntity(LigneCommandeClient lIgneCommandeClient){
        if(lIgneCommandeClient==null){
            return null;
        }
        else{
            LigneCommandeClientDto ligneCommandeClientDto=new LigneCommandeClientDto();
            ligneCommandeClientDto.article.fromEntity(lIgneCommandeClient.getArticle());
            ligneCommandeClientDto.commandeClient.fromEntity(lIgneCommandeClient.getCommandeClient());
            ligneCommandeClientDto.setQuantite(lIgneCommandeClient.getQuantite());
            ligneCommandeClientDto.setId(lIgneCommandeClient.getId());
            ligneCommandeClientDto.setPrixUnitaire(lIgneCommandeClient.getPrixUnitaire());
            return ligneCommandeClientDto;
        }
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if(ligneCommandeClientDto==null){
            return null;
        }
        else{
            LigneCommandeClient ligneCommandeClient=new LigneCommandeClient();
            ligneCommandeClient.setArticle(ligneCommandeClientDto.article.toEntity(ligneCommandeClientDto.getArticle()));
            ligneCommandeClient.setCommandeClient(ligneCommandeClientDto.commandeClient.toEntity(ligneCommandeClientDto.getCommandeClient()));
            ligneCommandeClientDto.setQuantite(ligneCommandeClient.getQuantite());
            ligneCommandeClientDto.setPrixUnitaire(ligneCommandeClient.getPrixUnitaire());
            return ligneCommandeClient;
        }
    }
}
