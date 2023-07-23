package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer > {
    Optional<CommandeClient> findByCode(String code);
}
