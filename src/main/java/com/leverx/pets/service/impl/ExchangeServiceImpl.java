package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.ExchangePetsRequestDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.entity.Pet;
import com.leverx.pets.mapper.OwnerMapper;
import com.leverx.pets.service.ExchangeService;
import com.leverx.pets.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class ExchangeServiceImpl implements ExchangeService { // TODO: 7/5/2021 FIX IT

    private final OwnerMapper ownerMapper;

    private final PetService petService;

    @Override
    public void exchangePets(ExchangePetsRequestDTO exchangePetsRequest) {
        log.trace("Method is invoked");

        Long firstPetId = exchangePetsRequest.getFirstPetId();
        Long secondPetId = exchangePetsRequest.getSecondPetId();

        log.debug("Pet's ids for exchange = [{},{}]", firstPetId, secondPetId);


            Pet firstPet = petService.findEntityPetById(firstPetId);
            Pet secondPet = petService.findEntityPetById(secondPetId);

            log.trace("Pets checking started");
            log.trace("Pets checking completed");

            Owner firstOwner = firstPet.getOwner();
            Owner secondOwner = secondPet.getOwner();

            log.trace("Owners checking started");
            log.trace("Owners checking completed");

            log.debug("Owner's ids for exchange = [{},{}]", firstOwner.getId(), secondOwner.getId());


        log.debug("Exchange is completed successfully");
    }


}
