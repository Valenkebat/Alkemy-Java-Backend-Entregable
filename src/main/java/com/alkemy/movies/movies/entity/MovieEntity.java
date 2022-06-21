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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String image;
    private String title;
    private int calification;

    @Column(nullable = false)
    private LocalDate creation_date;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private GenderEntity gender;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name= "movie_character",
            joinColumns = @JoinColumn(name = "movie_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"))
            private Set<CharacterEntity> characters = new HashSet<>();

    @Override
    public boolean equals(Object obj){
        if( obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final MovieEntity other = (MovieEntity) obj;
        return other.id == this.id;
    }

}
