/*
Película o Serie:
○ Este ítem deberá contener
■ Imagen
■ Título
■ Fecha de creación
■ Calificación (del 1 al 5)
■ Personajes asociados
* */

package com.alkemy.movies.movies.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String image;
    private String titulo;

    private int calificacion;


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name= "personaje_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
            private Set<PesonajeEntity> personajes = new HashSet<>();
}
