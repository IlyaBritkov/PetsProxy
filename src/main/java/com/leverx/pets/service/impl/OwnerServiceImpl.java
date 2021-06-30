package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.EntityDoesNotExistException;
import com.leverx.pets.mapper.OwnerMapper;
import com.leverx.pets.repository.OwnerRepository;
import com.leverx.pets.service.EntityCheckExistenceService;
import com.leverx.pets.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper;

    private final EntityCheckExistenceService entityCheckExistenceService;

    @Override
    public Flux<Owner> findAll() {
        log.trace("Method is invoked");

        return ownerRepository.findAll();
    }

    @Override
    public Mono<Owner> findById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        Mono<Owner> ownerById = findEntityById(id);

        log.debug("Owner by id = {} was found: {}", id, ownerById);

        return ownerById;
    }

    @Override
    public Mono<Owner> findEntityById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        return ownerRepository.findById(id);
    }

    @Override
    public OwnerResponseDTO create(OwnerCreateRequestDTO ownerRequestDTO) {
        log.trace("Method is invoked");

        Owner newOwner = ownerMapper.toEntity(ownerRequestDTO);
        ownerRepository.save(newOwner);

        log.debug("New owner was created and saved: {}", newOwner);

        return ownerMapper.toResponseDTO(newOwner);
    }

    @Override
    public OwnerResponseDTO updateById(Long id, OwnerUpdateRequestDTO ownerUpdateRequestDTO) throws EntityDoesNotExistException {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        log.trace("Method is invoked");

        boolean isOwnerExistsById = entityCheckExistenceService.isOwnerExistsById(id);

        log.debug("Is owner by id = {} exists:{}", id, isOwnerExistsById);

        return isOwnerExistsById;
    }

    @Override
    public void deleteById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

//        if (!existsById(id)) {
//            throw new EntityDoesNotExistException(String.format("Owner with id = %d doesnt exists", id), NOT_FOUND);
//        }
//
//        findEntityById(id)
//                .getPets()
//                .stream()
//                .filter(Objects::nonNull)
//                .forEach(pet -> pet.setOwner(null));
//
//        ownerRepository.deleteById(id);
//        log.debug("Owner by id = {} was deleted", id);
    }
}
