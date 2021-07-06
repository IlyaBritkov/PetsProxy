package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.DogCreateRequestDTO;
import com.leverx.pets.dto.request.update.DogUpdateRequestDTO;
import com.leverx.pets.dto.response.DogResponseDTO;
import com.leverx.pets.entity.Dog;
import com.leverx.pets.exception.RequestException;

import java.util.List;

public interface DogService {
    List<DogResponseDTO> findAll() throws RequestException;

    DogResponseDTO findById(Long id) throws RequestException;

    Dog findEntityById(Long id) throws RequestException;

    void create(DogCreateRequestDTO dogRequestDTO) throws RequestException;

    DogResponseDTO updateById(Long id, DogUpdateRequestDTO dogUpdateRequestDTO) throws RequestException;

    boolean existsById(Long id);

    void deleteById(Long id) throws RequestException;
}
