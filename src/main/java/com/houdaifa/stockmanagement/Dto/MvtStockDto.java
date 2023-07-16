package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.MvtStk;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MvtStockDto {
    private Integer id;
    private Instant dateMvt;
    private BigDecimal quantite;
    private ArticleDto article;
    public static MvtStockDto fromEntity(MvtStk mvtStk){
        MvtStockDto mvtStockDto=new MvtStockDto();
        mvtStockDto.setId(mvtStk.getId());
        mvtStockDto.setDateMvt(mvtStk.getDateMvt());
        mvtStockDto.setQuantite(mvtStk.getQuantite());
        mvtStockDto.article.fromEntity(mvtStk.getArticle());
        return mvtStockDto;
    }
    public static MvtStk toEntity(MvtStockDto mvtStockDto){
        if(mvtStockDto==null){
            return null;
        }
        else{
            MvtStk mvtStk = new MvtStk();
            mvtStk.setDateMvt(mvtStockDto.getDateMvt());
            mvtStk.setQuantite(mvtStockDto.getQuantite());
            mvtStk.setArticle(mvtStockDto.article.toEntity(mvtStockDto.getArticle()));
            return mvtStk;
        }
    }
}
