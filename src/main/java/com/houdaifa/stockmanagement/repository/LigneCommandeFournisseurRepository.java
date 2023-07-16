package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository< LigneCommandeFournisseur,Integer> {
}
