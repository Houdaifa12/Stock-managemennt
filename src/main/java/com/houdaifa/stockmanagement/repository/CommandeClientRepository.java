package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer > {
}
