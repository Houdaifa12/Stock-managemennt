package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.LigneVente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LigneVentesDto {
    private Integer id;

    private VentesDto ventesDto;

    private  ArticleDto articleDto;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
    public static  LigneVentesDto fromEntity(LigneVente ligneVente){
         LigneVentesDto ligneVentesDto=new LigneVentesDto();
         ligneVentesDto.setArticleDto(ArticleDto.fromEntity(ligneVente.getArticle()));
         ligneVentesDto.setQuantite(ligneVente.getQuantite());
         ligneVentesDto.setId(ligneVente.getId());
         ligneVentesDto.setPrixUnitaire(ligneVente.getPrixUnitaire());
         ligneVentesDto.setVentesDto(VentesDto.fromEntity(ligneVente.getVentes()));
         return ligneVentesDto;
    }
    public static  LigneVente fromEntity(LigneVentesDto ligneVenteDto){
        LigneVente ligneVente=new LigneVente();
        ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticleDto()));
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setId(ligneVente.getId());
        ligneVente.setPrixUnitaire(ligneVente.getPrixUnitaire());
        ligneVente.setVentes(VentesDto.toEntity(ligneVenteDto.getVentesDto()));
        return ligneVente;
    }

}
