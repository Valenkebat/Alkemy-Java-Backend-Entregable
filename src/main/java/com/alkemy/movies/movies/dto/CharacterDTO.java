package com.alkemy.movies.movies.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CharacterDTO {
    private Long id;
    private String image;
    private String name;
    private int age;
    private double weight;
    private String history;
}
