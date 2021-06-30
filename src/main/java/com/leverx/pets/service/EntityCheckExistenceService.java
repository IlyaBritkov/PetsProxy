package com.leverx.pets.service;

import com.leverx.pets.exception.EntityDoesNotExistException;

public interface EntityCheckExistenceService {

    boolean isCatExistsById(Long id);

    boolean isDogExistsById(Long id);

    boolean isOwnerExistsById(Long id);

    void checkOwnerExistenceById(Long id) throws EntityDoesNotExistException;
}
