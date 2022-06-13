/*
Género:
○ Este ítem deberá tener:
■ Nombre
■ Imagen
■ Películas o series asociadas
 */

package com.alkemy.movies.movies.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genero")
@Getter
@Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true)
    private String nombre;
    private String imagen;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id",referencedColumnName = "id")
    private List<PeliculaEntity> peliculas = new ArrayList<>();

}
