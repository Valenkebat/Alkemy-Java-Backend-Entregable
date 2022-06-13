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
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name= "personaje_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id",referencedColumnName = "id"))
    private Set<PeliculaEntity> peliculas = new HashSet<>();

}
