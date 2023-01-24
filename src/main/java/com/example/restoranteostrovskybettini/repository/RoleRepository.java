package com.example.restoranteostrovskybettini.repository;

import com.example.restoranteostrovskybettini.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
