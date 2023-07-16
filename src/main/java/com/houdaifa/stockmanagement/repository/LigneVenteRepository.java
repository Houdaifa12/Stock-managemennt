package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {
}
