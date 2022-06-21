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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@Table(name = "character")
@Getter
@Setter
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String image;
    private String name;
    private int age;
    private double weight;
    private String history;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<MovieEntity> movies = new ArrayList<>();

    public void addMovie(MovieEntity movie){ this.movies.add(movie);}
    public void removeMovie(MovieEntity movie){ this.movies.remove(movie);}
}
