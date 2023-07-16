package com.houdaifa.stockmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
public class Article extends AbstractEntity {
    @Column(name="codearticle")
    private String codeArticle;
    @Column(name="designation")
    private String designation;
    @Column(name="tauxtva")
    private BigDecimal tauxTva;
    @Column(name="prixunitaireht")
    private BigDecimal prixUnitaireHt;
    @Column(name="prixunitairettc")
    private BigDecimal prixUnitaireTtc;
    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;
}
