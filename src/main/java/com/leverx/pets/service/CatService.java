package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.CatCreateRequestDTO;
import com.leverx.pets.dto.request.update.CatUpdateRequestDTO;
import com.leverx.pets.dto.response.CatResponseDTO;
import com.leverx.pets.entity.Cat;
import com.leverx.pets.exception.RequestException;

import java.util.List;

public interface CatService {

    List<CatResponseDTO> findAll() throws RequestException;

    CatResponseDTO findById(Long id) throws RequestException;

    Cat findEntityById(Long id) throws RequestException;

    void create(CatCreateRequestDTO catRequestDTO) throws RequestException;

    CatResponseDTO updateById(Long id, CatUpdateRequestDTO catUpdateRequestDTO) throws RequestException;

    boolean existsById(Long id);

    void deleteById(Long id) throws RequestException;
}
