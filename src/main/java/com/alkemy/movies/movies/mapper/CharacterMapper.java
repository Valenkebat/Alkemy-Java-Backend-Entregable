package com.alkemy.movies.movies.mapper;
import com.alkemy.movies.movies.dto.CharacterDTO;
import com.alkemy.movies.movies.dto.MovieDTO;
import com.alkemy.movies.movies.entity.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class CharacterMapper {

    @Autowired
    private MovieMapper movieMapper;

    public CharacterEntity CharacterDTO2Entity(CharacterDTO dto){
        CharacterEntity entity = new CharacterEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
        return entity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity,  boolean loadMovies){
        CharacterDTO dto = new CharacterDTO();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());
        if(loadMovies){
            List<MovieDTO> moviesDTOS = this.movieMapper.movieEntityList2DTOlist(entity.getMovies(),false);
            dto.setCharacters(moviesDTOS);
        }
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOlist(List<CharacterEntity> entities , boolean loadMovies) {
        List<CharacterDTO> dtos = new ArrayList<>();
        for (CharacterEntity entity: entities) {
            dtos.add(this.characterEntity2DTO(entity, loadMovies));
        }
        return dtos;
    }

}
