package com.example.restoranteostrovskybettini.Interface;

import com.example.restoranteostrovskybettini.dto.UsuarioRegistroDTO;
import com.example.restoranteostrovskybettini.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {

    public Usuario guardarUsuario(UsuarioRegistroDTO registroDTO);

    public List<Usuario> listarUsuarios();


}
