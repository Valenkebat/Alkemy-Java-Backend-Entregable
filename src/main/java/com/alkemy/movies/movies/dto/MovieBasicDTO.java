package com.alkemy.movies.movies.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class MovieBasicDTO {
    private Long id;
    private String image;
    private String title;
    private int calification;
    private Date creation_date;
    private GenderDTO gender;
}
