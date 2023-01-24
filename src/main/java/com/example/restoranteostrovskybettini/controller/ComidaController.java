package com.example.restoranteostrovskybettini.controller;

import com.example.restoranteostrovskybettini.entity.Comida;
import com.example.restoranteostrovskybettini.Interface.ComidaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComidaController {

    private ComidaService comidaService;

    public ComidaController(ComidaService comidaService){

        this.comidaService = comidaService;
    }

    /**
     * Busca todas las comidas en la base de datos
     * @return Devuelve una lista con todas las comidas que estan en la base de datos
     */
    @GetMapping("/comidas")
    public String listarTodasLasComidas(Model modelo){
        modelo.addAttribute("comidas",comidaService.listarTodasLasComidas());
        return "/comidas/comidas";  //retorna un html comidas
    }

    /**
     * Muestra un formulario para crear una nueva comida
     * @return Un formulario html para cargar una nueva comida a la base de datos
     */
    @GetMapping("/comidas/nueva")
    public String mostrarFormularioComidaNueva(Model modelo){
        Comida comida = new Comida();
        modelo.addAttribute("comida", comida);
        return "/comidas/crear_comida";
    }

    /**
     * Guarda la nueva comida que se cargo en la base de datos
     * @return Lista html comidas
     */
    @PostMapping("/comidas")
    public String guardarComidas(@ModelAttribute("comida") Comida comida){
        comidaService.guardarComida(comida);
        return "redirect:/comidas";
    }

    /**
     * Muestra un formulario pora editar una comida existente
     * @return Formulario html
     */
    @GetMapping("/comidas/editar/{id}")
    public String mostrarFormularioEditarComida(@PathVariable Long id, Model modelo){
        modelo.addAttribute("comida",comidaService.obtenerComidaPorId(id));
        return "/comidas/editar_comida";
    }

    /**
     * Actualiza y guarda la comida editada
     * @return Lista html comidas
     */
    @PostMapping("/comidas/{id}")
    public String actualizarComida(@PathVariable Long id, @ModelAttribute("comida") Comida comida, Model modelo){
        Comida comidaExistente = comidaService.obtenerComidaPorId(id);
        comidaExistente.setId(id);
        comidaExistente.setNombre(comida.getNombre());
        comidaExistente.setPrecio(comida.getPrecio());

        comidaService.actualizarComida(comidaExistente);
        return "redirect:/comidas";
    }

    /**
     * Elimina una comida de la base de datos
     * @return Lista Html comidas
     */
    @GetMapping("/comidas/{id}")
    public String eliminarComida(@PathVariable Long id){
        comidaService.eliminarComida(id);
        return "redirect:/comidas";
    }

}
