package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.create.DogCreateRequestDTO;
import com.leverx.pets.dto.request.update.DogUpdateRequestDTO;
import com.leverx.pets.dto.response.DogResponseDTO;
import com.leverx.pets.entity.Dog;
import com.leverx.pets.exception.EntityDoesNotExistException;
import com.leverx.pets.mapper.DogMapper;
import com.leverx.pets.repository.DogRepository;
import com.leverx.pets.service.DogService;
import com.leverx.pets.service.EntityCheckExistenceService;
import com.leverx.pets.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    private final DogMapper dogMapper;

    private final EntityCheckExistenceService entityCheckExistenceService;

    private final OwnerService ownerService;

    @Override
    public List<DogResponseDTO> findAll() {
        log.trace("Method is invoked");

        List<Dog> allDogs = dogRepository.findAll();

        log.debug("Amount of all dogs = {}", allDogs.size());

        return allDogs.stream()
                .map(dogMapper::toResponseDTO)
                .collect(toList());
    }

    @Override
    public DogResponseDTO findById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        Dog dogById = findEntityById(id);

        log.debug("Dog by id = {} was found: {}", id, dogById);

        return dogMapper.toResponseDTO(dogById);
    }

    @Override
    public Dog findEntityById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");
//
//        return dogRepository.findById(id)
//                .orElseThrow(() -> new EntityDoesNotExistException(String.format("Dog with id = %d doesnt exists", id), NOT_FOUND));
        return null;
    }

    @Override
    public DogResponseDTO create(DogCreateRequestDTO dogRequestDTO) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

//        Long requestOwnerId = dogRequestDTO.getOwnerId();
//        entityCheckExistenceService.checkOwnerExistenceById(requestOwnerId);
//
//        Owner ownerById = ownerService.findEntityById(requestOwnerId);
//
//        Dog newDog = dogMapper.toEntity(dogRequestDTO);
//        newDog.setOwner(ownerById);
//        dogRepository.save(newDog);
//
//        log.debug("New cat was created and saved: {}", newDog);

//        return dogMapper.toResponseDTO(newDog);
        return null;
    }

    @Override
    public DogResponseDTO updateById(Long id, DogUpdateRequestDTO dogUpdateRequestDTO) throws EntityDoesNotExistException {
//        log.trace("Method is invoked");
//
//        if (!existsById(id)) {
//            throw new EntityDoesNotExistException(String.format("Dog with id = % doesnt exists", id)
//                    , NOT_FOUND);
//        }
//
//        Long requestOwnerId = dogUpdateRequestDTO.getOwnerId();
//
//        if (requestOwnerId != null) {
//            entityCheckExistenceService.checkOwnerExistenceById(requestOwnerId);
//        }
//
//        Dog dogById = findEntityById(id);
//
//        dogMapper.updateEntity(dogUpdateRequestDTO, dogById);
//        dogRepository.save(dogById);
//
//        log.debug("Dog by id = {} was updated: {}", id, dogById);
//
//        return dogMapper.toResponseDTO(dogById);
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        log.trace("Method is invoked");

        boolean isDogExistsById = entityCheckExistenceService.isDogExistsById(id);

        log.debug("Is dog by id = {} exists:{}", id, isDogExistsById);

        return isDogExistsById;
    }

    @Override

    public void deleteById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

//        try {
//            dogRepository.deleteById(id);
//        } catch (EmptyResultDataAccessException ex) {
//            throw new EntityDoesNotExistException(String.format("Dog with id = %d doesnt exists", id),
//                    NOT_FOUND);
//        }

        log.debug("Dog by id = {} was deleted", id);
    }

    @Override
    public void delete(Dog dog) {
        log.trace("Method is invoked");

//        dogRepository.delete(dog);
    }
}