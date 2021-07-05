package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.RequestException;

import java.util.List;

public interface OwnerService {

    List<Owner> findAll() throws RequestException;

    Owner findById(Long id) throws RequestException;

    Owner findEntityById(Long id) throws RequestException;

    OwnerResponseDTO create(OwnerCreateRequestDTO ownerRequestDTO);

    OwnerResponseDTO updateById(Long id, OwnerUpdateRequestDTO ownerUpdateRequestDTO);

    boolean existsById(Long id);

    void deleteById(Long id) ;
}
