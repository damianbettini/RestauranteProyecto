package com.example.restoranteostrovskybettini.repository;

import com.example.restoranteostrovskybettini.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida,Long> {
}
