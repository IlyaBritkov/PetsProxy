package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.DogCreateRequestDTO;
import com.leverx.pets.dto.request.update.DogUpdateRequestDTO;
import com.leverx.pets.dto.response.DogResponseDTO;
import com.leverx.pets.entity.Dog;
import com.leverx.pets.exception.EntityDoesNotExistException;

import java.util.List;

public interface DogService {
    List<DogResponseDTO> findAll();

    DogResponseDTO findById(Long id) throws EntityDoesNotExistException;

    Dog findEntityById(Long id) throws EntityDoesNotExistException;

    DogResponseDTO create(DogCreateRequestDTO dogRequestDTO) throws EntityDoesNotExistException;

    DogResponseDTO updateById(Long id, DogUpdateRequestDTO dogUpdateRequestDTO) throws EntityDoesNotExistException;

    boolean existsById(Long id);

    void deleteById(Long id) throws EntityDoesNotExistException;

    void delete(Dog dog);
}
