package com.alkemy.movies.movies.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String image;
    private String title;
    private int calification;
    private Date creation_date;
    private GenderDTO gender;
    private List<CharacterDTO> characters;
}
