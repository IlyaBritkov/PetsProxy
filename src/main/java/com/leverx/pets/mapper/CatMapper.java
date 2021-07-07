package com.leverx.pets.mapper;

import com.leverx.pets.dto.request.create.CatCreateRequestDTO;
import com.leverx.pets.dto.request.update.CatUpdateRequestDTO;
import com.leverx.pets.dto.response.CatResponseDTO;
import com.leverx.pets.entity.Cat;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE
)
public abstract class CatMapper {

    public abstract CatResponseDTO toResponseDTO(Cat cat);

    public abstract Cat toEntity(CatCreateRequestDTO createRequest);

    public abstract void updateEntity(CatUpdateRequestDTO updateDTO, @MappingTarget Cat cat);
}
