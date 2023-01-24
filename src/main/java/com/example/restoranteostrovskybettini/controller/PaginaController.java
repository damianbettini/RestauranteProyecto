package com.example.restoranteostrovskybettini.controller;


import com.example.restoranteostrovskybettini.Interface.BebidaService;
import com.example.restoranteostrovskybettini.Interface.ComidaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

    private ComidaService comidaService;
    private BebidaService bebidaService;

    public PaginaController(ComidaService comidaService, BebidaService bebidaService){

        this.comidaService = comidaService;
        this.bebidaService = bebidaService;
    }

    /**
     * Muesta una pagina html para ingresar sesion
     */
    @GetMapping("/login")
    public String index() {
        return "/pagina/index";
    }

    /**
     * Muestra una pagina html de bienvenida
     */
    @GetMapping({"/bienvenido" , "/"})
    public String principal(){
        return "/pagina/principal";
    }

    /**
     * Muestra una pagina html con el menu
     */
    @GetMapping("/menu")
    public String menu(Model modelo){
        modelo.addAttribute("comidas",comidaService.listarTodasLasComidas());
        modelo.addAttribute("bebidas",bebidaService.listarTodasLasBebidas());
        return "/pagina/menu";
    }




    }


