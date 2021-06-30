package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.CatCreateRequestDTO;
import com.leverx.pets.dto.request.update.CatUpdateRequestDTO;
import com.leverx.pets.dto.response.CatResponseDTO;
import com.leverx.pets.entity.Cat;
import com.leverx.pets.exception.EntityDoesNotExistException;

import java.util.List;

public interface CatService {

    List<CatResponseDTO> findAll();

    CatResponseDTO findById(Long id) throws EntityDoesNotExistException;

    Cat findEntityById(Long id) throws EntityDoesNotExistException;

    CatResponseDTO create(CatCreateRequestDTO catRequestDTO) throws EntityDoesNotExistException;

    CatResponseDTO updateById(Long id, CatUpdateRequestDTO catUpdateRequestDTO) throws EntityDoesNotExistException;

    boolean existsById(Long id);

    void deleteById(Long id) throws EntityDoesNotExistException;
}
