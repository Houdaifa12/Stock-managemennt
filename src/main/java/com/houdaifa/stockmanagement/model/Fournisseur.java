package com.houdaifa.stockmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="fournisseur")
public class Fournisseur extends AbstractEntity {
   @Column(name = "nom")
   private String nom;

   @Column(name = "prenom")
   private String prenom;

   @Embedded
   private Adresse adresse;

   @Column(name = "photo")
   private String photo;

   @Column(name = "numTel")
   private String numTel;

   @Column(name="mail")
   private String mail;

   @OneToMany(mappedBy = "fournisseur")
   private List<CommandeFournisseur> commandeFoirnisseurs;
}
