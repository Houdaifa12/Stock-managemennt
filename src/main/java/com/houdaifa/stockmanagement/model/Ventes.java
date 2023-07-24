package com.houdaifa.stockmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventes")
public class Ventes extends AbstractEntity {
@Column(name="code")
private String code;

@Column(name="datevente")
private Instant dateVente;

@Column(name="commentaire")
private String commentaire;
@OneToMany(mappedBy = "ventes")
private List<LigneVente>ligneVentes;
}
