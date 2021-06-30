package com.leverx.pets.mapper;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE
)
public abstract class OwnerMapper {

    @Mapping(source = "pets", target = "petIds", qualifiedByName = "mapPetsToPetIds")
    public abstract OwnerResponseDTO toResponseDTO(Owner owner);

    public abstract Owner toEntity(OwnerCreateRequestDTO createRequest);

    public abstract void updateEntity(OwnerUpdateRequestDTO updateDTO, @MappingTarget Owner owner);

    @Named("mapPetsToPetIds")
    protected List<Long> mapPetsToPetIds(List<Pet> pets) {
        return pets.stream()
                .filter(Objects::nonNull)
                .map(Pet::getId)
                .collect(toList());
    }
}
