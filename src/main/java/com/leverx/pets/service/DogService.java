package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.DogCreateRequestDTO;
import com.leverx.pets.dto.request.update.DogUpdateRequestDTO;
import com.leverx.pets.dto.response.DogResponseDTO;
import com.leverx.pets.entity.Dog;

import java.util.List;

public interface DogService {
    List<DogResponseDTO> findAll();

    DogResponseDTO findById(Long id) ;

    Dog findEntityById(Long id) ;

    DogResponseDTO create(DogCreateRequestDTO dogRequestDTO) ;

    DogResponseDTO updateById(Long id, DogUpdateRequestDTO dogUpdateRequestDTO) ;

    boolean existsById(Long id);

    void deleteById(Long id);

    void delete(Dog dog);
}
