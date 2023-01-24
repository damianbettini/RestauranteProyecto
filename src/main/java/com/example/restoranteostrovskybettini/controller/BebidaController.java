package com.example.restoranteostrovskybettini.controller;

import com.example.restoranteostrovskybettini.entity.Bebida;
import com.example.restoranteostrovskybettini.Interface.BebidaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BebidaController {

    private BebidaService bebidaService;

    public BebidaController(BebidaService bebidaService){
        this.bebidaService = bebidaService;
    }

    /**
     * Busca todas las bebidas en la base de datos
     * @return Devuelve una lista con todas la bebidas que estan en la base de datos
     */
    @GetMapping("/bebidas")
    public String listarTodasLasBebidas(Model modelo){
        modelo.addAttribute("bebidas",bebidaService.listarTodasLasBebidas());
        return "/bebidas/bebidas";  //retorna un html bebidas
    }

    /**
     * Muestra un formulario para crear una nueva bebida
     * @return Un formulario html para cargar una nueva bebida a la base de datos
     */
    @GetMapping("/bebidas/nueva")
    public String mostrarFormularioBebidaNueva(Model modelo){
        Bebida bebida = new Bebida();
        modelo.addAttribute("bebida", bebida);
        return "/bebidas/crear_bebida";
    }

    /**
     * Guarda la nueva bebida que se cargo en la base de datos
     * @return Lista html bebidas
     */
    @PostMapping("/bebidas")
    public String guardarBebidas(@ModelAttribute("bebida") Bebida bebida){
        bebidaService.guardarBebida(bebida);
        return "redirect:/bebidas";
    }

    /**
     * Muestra un formulario pora editar una bebida existente
     * @return Formulario html
     */
    @GetMapping("/bebidas/editar/{id}")
    public String mostrarFormularioEditarBebida(@PathVariable Long id, Model modelo){
        modelo.addAttribute("bebida",bebidaService.obtenerBebidaPorId(id));
        return "/bebidas/editar_bebida";
    }

    /**
     * Actualiza y guarda la bebida editada
     * @return Lista html bebidas
     */
    @PostMapping("/bebidas/{id}")
    public String actualizarBebida(@PathVariable Long id, @ModelAttribute("bebida") Bebida bebida, Model modelo){
        Bebida bebidaExistente = bebidaService.obtenerBebidaPorId(id);
        bebidaExistente.setId(id);
        bebidaExistente.setNombre(bebida.getNombre());
        bebidaExistente.setPrecio(bebida.getPrecio());
        bebidaExistente.setCategoriaBebida(bebida.getCategoriaBebida());

        bebidaService.actualizarBebida(bebidaExistente);
        return "redirect:/bebidas";
    }

    /**
     * Elimina una bebida de la base de datos
     * @return Lista Html bebidas
     */
    @GetMapping("/bebidas/{id}")
    public String eliminarBebida(@PathVariable Long id){
        bebidaService.eliminarBebida(id);
        return "redirect:/bebidas";
    }

}
