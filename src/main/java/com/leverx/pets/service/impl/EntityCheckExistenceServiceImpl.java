package com.leverx.pets.service.impl;

import com.leverx.pets.exception.EntityDoesNotExistException;
import com.leverx.pets.repository.CatRepository;
import com.leverx.pets.repository.DogRepository;
import com.leverx.pets.repository.OwnerRepository;
import com.leverx.pets.service.EntityCheckExistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class EntityCheckExistenceServiceImpl implements EntityCheckExistenceService {

    private final CatRepository catRepository;

    private final DogRepository dogRepository;

    private final OwnerRepository ownerRepository;

    @Override
    public boolean isCatExistsById(Long id) {
        log.trace("Method is invoked");

//        return catRepository.existsById(id);
        return false;
    }

    @Override
    public boolean isDogExistsById(Long id) {
        log.trace("Method is invoked");

//        return dogRepository.existsById(id);
        return false;
    }

    @Override
    public boolean isOwnerExistsById(Long id) {
        log.trace("Method is invoked");

//        return ownerRepository.existsById(id);
        return false;
    }

    @Override
    public void checkOwnerExistenceById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        if (!isOwnerExistsById(id)) {
            throw new EntityDoesNotExistException(String.format("Owner with id = %d doesnt exists", id),
                    BAD_REQUEST);
        }

        log.debug("Owner by id = {} exists", id);
    }
}
