package com.leverx.pets.mapper;

import com.leverx.pets.dto.request.create.DogCreateRequestDTO;
import com.leverx.pets.dto.request.update.DogUpdateRequestDTO;
import com.leverx.pets.dto.response.DogResponseDTO;
import com.leverx.pets.entity.Dog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE
)
public abstract class DogMapper {

    public abstract DogResponseDTO toResponseDTO(Dog dog);

    public abstract Dog toEntity(DogCreateRequestDTO createRequest);

    public abstract void updateEntity(DogUpdateRequestDTO updateDTO, @MappingTarget Dog dog);
}
