package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.CatCreateRequestDTO;
import com.leverx.pets.dto.request.update.CatUpdateRequestDTO;
import com.leverx.pets.dto.response.CatResponseDTO;
import com.leverx.pets.entity.Cat;

import java.util.List;

public interface CatService {

    List<CatResponseDTO> findAll();

    CatResponseDTO findById(Long id) ;

    Cat findEntityById(Long id) ;

    CatResponseDTO create(CatCreateRequestDTO catRequestDTO);

    CatResponseDTO updateById(Long id, CatUpdateRequestDTO catUpdateRequestDTO);

    boolean existsById(Long id);

    void deleteById(Long id);
}
