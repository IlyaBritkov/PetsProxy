package com.leverx.pets.service;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.EntityDoesNotExistException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OwnerService {
    Flux<Owner> findAll();

    Mono<Owner> findById(Long id) throws EntityDoesNotExistException;

    Mono<Owner> findEntityById(Long id) throws EntityDoesNotExistException;

    OwnerResponseDTO create(OwnerCreateRequestDTO ownerRequestDTO);

    OwnerResponseDTO updateById(Long id, OwnerUpdateRequestDTO ownerUpdateRequestDTO) throws EntityDoesNotExistException;

    boolean existsById(Long id);

    void deleteById(Long id) throws EntityDoesNotExistException;
}
