package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.RequestException;

import java.util.List;

public interface OwnerService {

    List<OwnerResponseDTO> findAll() throws RequestException;

    OwnerResponseDTO findById(Long id) throws RequestException;

    Owner findEntityById(Long id) throws RequestException;

    void create(OwnerCreateRequestDTO ownerRequestDTO) throws RequestException;

    OwnerResponseDTO updateById(Long id, OwnerUpdateRequestDTO ownerUpdateRequestDTO) throws RequestException;

    boolean existsById(Long id);

    void deleteById(Long id) throws RequestException;
}
