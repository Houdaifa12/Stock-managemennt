package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository< LigneCommandeClient,Integer> {
}
