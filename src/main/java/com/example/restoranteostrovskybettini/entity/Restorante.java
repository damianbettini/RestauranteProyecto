package com.example.restoranteostrovskybettini.entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restorante{

    private String nombre;

    @OneToMany
    private ArrayList<Comida> comidas;

    @OneToMany
    private ArrayList<Bebida> bebidas;
}
