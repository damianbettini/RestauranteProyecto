package com.example.restoranteostrovskybettini.repository;

import com.example.restoranteostrovskybettini.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByEmail(String email);
}
