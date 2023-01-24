package com.example.restoranteostrovskybettini;

import com.example.restoranteostrovskybettini.repository.UsuarioRepository;
import com.example.restoranteostrovskybettini.service.RestauranteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class RestoranteOstrovskyBettiniApplication{

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RestoranteOstrovskyBettiniApplication.class, args);

        UsuarioRepository usuarioRepository = context.getBean(UsuarioRepository.class);

        RestauranteService resto = new RestauranteService(context);
        //resto.crearRestorante();

    }
}
