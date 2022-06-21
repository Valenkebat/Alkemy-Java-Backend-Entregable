package com.alkemy.movies.movies.mapper;
import com.alkemy.movies.movies.dto.CharacterDTO;
import com.alkemy.movies.movies.dto.MovieDTO;
import com.alkemy.movies.movies.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    @Autowired
    private CharacterMapper characterMapper;

    public MovieEntity movieDTO2Entity(MovieDTO dto){
        MovieEntity entity = new MovieEntity();
        entity.setImage(dto.getImage());
        entity.setCalification(dto.getCalification());
        entity.setTitle(entity.getTitle());
        return entity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacter){
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setCalification(entity.getCalification());
        dto.setTitle(entity.getTitle());
        //Genders
        if(loadCharacter){
            List<CharacterDTO> characterDTOS = this.characterMapper.characterEntityList2DTOlist(entity.getCharacters(),false);
            dto.setCharacters(characterDTOS);
        }
        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOlist(List<MovieEntity> entities, boolean loadCharacter ) {
        List<MovieDTO> dtos = new ArrayList<>();
        for (MovieEntity entity: entities) {
            dtos.add(movieEntity2DTO(entity, loadCharacter));
        }
        return dtos;
    }
}
