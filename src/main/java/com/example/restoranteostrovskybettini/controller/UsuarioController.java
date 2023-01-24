package com.example.restoranteostrovskybettini.controller;

import com.example.restoranteostrovskybettini.Interface.UsuarioService;
import com.example.restoranteostrovskybettini.dto.UsuarioRegistroDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsuarioController {


    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    /**
     * Crea un usuario DTO
     * @return Un nuevo usuario DTO
     */
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUserRegistroDTO(){
        return new UsuarioRegistroDTO();
    }

    /**
     * Muestra formulario de registro de usuario
     * @return Un formulario de registro para usuario
     */
    @GetMapping("/registro")
    public String mostrarFormularioDeRegistro(){
        return "/pagina/registro";
    }

    /**
     * Guarda el nuevo usuario DTO en la base de datos
     * @return Un mensaje de usuario creado si se pudo crear
     */
    @PostMapping("/registro")
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO usuarioRegistroDTO){
        usuarioService.guardarUsuario(usuarioRegistroDTO);
        return "redirect:/registro?exito";
    }




}

