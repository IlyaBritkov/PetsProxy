package com.leverx.pets.mapper;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE
)
public abstract class OwnerMapper {

    public abstract OwnerResponseDTO toResponseDTO(Owner owner);

    public abstract Owner toEntity(OwnerCreateRequestDTO createRequest);

    public abstract void updateEntity(OwnerUpdateRequestDTO updateDTO, @MappingTarget Owner owner);
}
