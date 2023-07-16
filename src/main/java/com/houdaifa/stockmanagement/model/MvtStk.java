package com.houdaifa.stockmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mvtstock")
public class MvtStk extends AbstractEntity{

    @Column(name="datemvt")
    private Instant dateMvt;

    @Column(name="quantite")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    /*@Column(name="typemvt")
    private TypeMvtStk typemvt;
     */
}
