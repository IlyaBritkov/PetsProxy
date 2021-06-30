package com.leverx.pets.service;

import com.leverx.pets.dto.response.BasePetResponseDTO;
import com.leverx.pets.entity.Pet;
import com.leverx.pets.exception.EntityDoesNotExistException;

import java.util.List;

public interface PetService {

    List<BasePetResponseDTO> findAllPets();

    BasePetResponseDTO findPetById(Long petId) throws EntityDoesNotExistException;

    Pet findEntityPetById(Long petId) throws EntityDoesNotExistException;
}
