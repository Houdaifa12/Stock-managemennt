package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvtStkRepository extends JpaRepository< MvtStk,Integer> {
}
