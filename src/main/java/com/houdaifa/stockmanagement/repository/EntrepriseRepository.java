package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository< Entreprise,Integer> {
    Optional<Entreprise> findByNom(String nom);
}
