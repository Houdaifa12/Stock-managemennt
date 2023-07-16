package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentesRepository extends JpaRepository<Ventes,Integer> {
}
