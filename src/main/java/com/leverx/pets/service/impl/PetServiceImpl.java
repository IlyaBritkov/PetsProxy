package com.leverx.pets.service.impl;

import com.leverx.pets.dto.response.BasePetResponseDTO;
import com.leverx.pets.entity.Pet;
import com.leverx.pets.mapper.PetMapper;
import com.leverx.pets.repository.PetRepository;
import com.leverx.pets.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Qualifier("petMapperImpl")
    private final PetMapper petMapper;

    @Override
    public List<BasePetResponseDTO> findAllPets() {
        log.trace("Method is invoked");

        List<Pet> allPets = petRepository.findAll();

        log.debug("Amount of all pets = {}", allPets.size());

        return allPets.stream()
                .map(petMapper::toResponseDTO)
                .collect(toList());
    }

    @Override
    public BasePetResponseDTO findPetById(Long petId) {
        log.trace("Method is invoked");

        Pet petById = findEntityPetById(petId);

        log.debug("Pet by id = {} was found: {}", petId, petById);

        return petMapper.toResponseDTO(petById);
    }

    @Override
    public Pet findEntityPetById(Long petId) {
        log.trace("Method is invoked");

//        return petRepository.findById(petId)
//                .orElseThrow(() -> new EntityDoesNotExistException(String.format("Pet with id  =%d doesnt exist", petId)));
        return null;
    }
}
