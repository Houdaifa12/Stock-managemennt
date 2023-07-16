package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.Category;
import com.houdaifa.stockmanagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByNom(String nomClient);
}
