package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.ExchangePetsRequestDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.entity.Pet;
import com.leverx.pets.exception.EntityDoesNotExistException;
import com.leverx.pets.exception.ExchangeException;
import com.leverx.pets.mapper.OwnerMapper;
import com.leverx.pets.service.ExchangeService;
import com.leverx.pets.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final OwnerMapper ownerMapper;

    private final PetService petService;

    @Override
    public void exchangePets(ExchangePetsRequestDTO exchangePetsRequest) throws ExchangeException {
        log.trace("Method is invoked");

        Long firstPetId = exchangePetsRequest.getFirstPetId();
        Long secondPetId = exchangePetsRequest.getSecondPetId();

        log.debug("Pet's ids for exchange = [{},{}]", firstPetId, secondPetId);

        try {
            Pet firstPet = petService.findEntityPetById(firstPetId);
            Pet secondPet = petService.findEntityPetById(secondPetId);

            log.trace("Pets checking started");
            checkPets(firstPet, secondPet);
            log.trace("Pets checking completed");

            Owner firstOwner = firstPet.getOwner();
            Owner secondOwner = secondPet.getOwner();

            log.trace("Owners checking started");
            checkOwners(firstOwner, secondOwner);
            log.trace("Owners checking completed");

            log.debug("Owner's ids for exchange = [{},{}]", firstOwner.getId(), secondOwner.getId());


        } catch (EntityDoesNotExistException existException) {
            throw new ExchangeException(existException.getMessage(), BAD_REQUEST);
        }

        log.debug("Exchange is completed successfully");
    }


    protected void checkPets(Pet... pets) throws ExchangeException {
        log.trace("Method is invoked");

        for (Pet pet : pets) {
            if (!pet.getIsAlive()) {
                throw new ExchangeException("To exchange pets all pets should be alive."
                        , BAD_REQUEST);
            }
        }
    }

    protected void checkOwners(Owner firstOwner, Owner secondOwner) throws ExchangeException {
        log.trace("Method is invoked");

        if (firstOwner == null || secondOwner == null
                || firstOwner.equals(secondOwner)) {
            throw new ExchangeException(String.format("To exchange pets there is should be 2 different owners. Actual owners: [%s, %s]",
                    ownerMapper.toResponseDTO(firstOwner),
                    ownerMapper.toResponseDTO(secondOwner))
                    , BAD_REQUEST);
        }

        if (!firstOwner.getIsAlive() || !secondOwner.getIsAlive()) {
            throw new ExchangeException("To exchange pets owners should be alive."
                    , BAD_REQUEST);
        }
    }
}
