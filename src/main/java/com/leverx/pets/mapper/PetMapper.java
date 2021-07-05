package com.leverx.pets.mapper;

import com.leverx.pets.dto.response.BasePetResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.entity.Pet;
import com.leverx.pets.service.OwnerService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        implementationName = "petMapperImpl",
        uses = {
                OwnerService.class})
public abstract class PetMapper {

    @Autowired
    private OwnerService ownerService;

    @Mapping(source = "owner", target = "ownerId", qualifiedByName = "getOwnerIdFromOwner")
    public abstract BasePetResponseDTO toResponseDTO(Pet pet);

    @Named("getOwnerIdFromOwner")
    protected Long getOwnerIdFromOwner(Owner owner) {
        return owner == null ? null : owner.getId();
    }

    @Named("getOwnerFromOwnerId")
    protected Owner getOwnerFromOwnerId(Long ownerId) {
//        return ownerService.findEntityById(ownerId);
        return null;
    }
}
