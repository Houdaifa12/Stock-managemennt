package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository< Roles,Integer> {
}
