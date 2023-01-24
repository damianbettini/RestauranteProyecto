package com.example.restoranteostrovskybettini.service;

import com.example.restoranteostrovskybettini.entity.Bebida;
import com.example.restoranteostrovskybettini.entity.Comida;
import com.example.restoranteostrovskybettini.entity.Restorante;
import com.example.restoranteostrovskybettini.repository.BebidaRepository;
import com.example.restoranteostrovskybettini.repository.ComidaRepository;
import com.example.restoranteostrovskybettini.repository.UsuarioRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RestauranteService {


    private ComidaServiceImp comidaServiceImp;


    private BebidasServiceImp bebidasServiceImp;



    private ComidaRepository comidaRepository;
    private BebidaRepository bebidaRepository;
    private UsuarioRepository usuarioRepository;

    public RestauranteService(ApplicationContext context){
        this.comidaRepository = context.getBean(ComidaRepository.class);
        this.bebidaRepository = context.getBean(BebidaRepository.class);
        this.usuarioRepository = context.getBean(UsuarioRepository.class);
        this.bebidasServiceImp = context.getBean(BebidasServiceImp.class);
        this.comidaServiceImp = context.getBean(ComidaServiceImp.class);
    }

    public Restorante crearRestorante(){

        Restorante restorante = new Restorante();
        ArrayList<Comida> comidas = new ArrayList<>();
        ArrayList<Bebida> bebidas = new ArrayList<>();

        restorante.setNombre("BettiniOstrovsky");

        comidas = comidaServiceImp.crearListaComidas();
        bebidas = bebidasServiceImp.crearListaBebidas();
        restorante.setComidas(comidas);
        restorante.setBebidas(bebidas);



        for (Comida aux: comidas) {
            comidaRepository.save(aux);
        }


        for (Bebida aux: bebidas) {
            bebidaRepository.save(aux);
        }

        return restorante;
    }
}
