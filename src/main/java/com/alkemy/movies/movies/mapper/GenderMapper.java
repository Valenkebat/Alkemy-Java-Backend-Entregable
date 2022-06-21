package com.alkemy.movies.movies.mapper;

import com.alkemy.movies.movies.dto.GenderDTO;
import com.alkemy.movies.movies.entity.GenderEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenderMapper {

    public GenderEntity genderDTO2Entity(GenderDTO dto){
        GenderEntity entity = new GenderEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }

    public GenderDTO genderEntity2DTO(GenderEntity entity){
        GenderDTO dto = new GenderDTO();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }

    public List<GenderDTO> continentEntityList2DTOlist(List<GenderEntity> entities) {
        List<GenderDTO> dtos = new ArrayList<>();
        for (GenderEntity entity: entities) {
            dtos.add(this.genderEntity2DTO(entity));
        }
        return dtos;
    }

}
