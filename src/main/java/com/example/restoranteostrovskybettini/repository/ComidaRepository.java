package com.example.restoranteostrovskybettini.repository;

import com.example.restoranteostrovskybettini.entity.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Long> {
}
