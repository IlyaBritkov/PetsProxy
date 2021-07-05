package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.mapper.OwnerMapper;
import com.leverx.pets.repository.OwnerRepository;
import com.leverx.pets.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class OwnerServiceImpl implements OwnerService { // TODO: 7/5/2021 FIX IT

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper;

//    @Override
//    public Flux<Owner> findAll() {
//        log.trace("Method is invoked");
//
//        return ownerRepository.findAll();
//    }

    @Override
    public List<Owner> findAll() throws RequestException {
        log.trace("Method is invoked");

        return ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long id) throws RequestException {
        log.trace("Method is invoked");

        Owner ownerById = findEntityById(id);

        log.debug("Owner by id = {} was found: {}", id, ownerById);

        return ownerById;
    }

    @Override
    public Owner findEntityById(Long id) throws RequestException {
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
    public OwnerResponseDTO updateById(Long id, OwnerUpdateRequestDTO ownerUpdateRequestDTO)  {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        log.trace("Method is invoked");

        return false;
    }

    @Override
    public void deleteById(Long id) {
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
