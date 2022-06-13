/*
* Personaje: deberá tener:
○ Imagen
○ Nombre
○ Edad
○ Peso
○ Historia
○ Películas o series asociadas
* */

package com.alkemy.movies.movies.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PesonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String image;
    private String nombre;
    private int edad;
    private double peso;
    private String historia;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas = new ArrayList<>();


}
