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

@Entity
@Table(name = "gender")
@Getter
@Setter
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String name;
    private String image;
}
