package com.leverx.pets.controller;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.EntityDoesNotExistException;
import com.leverx.pets.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@RestController
@RequestMapping(value = "api/v1/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping()
    public ResponseEntity<Flux<Owner>> findAllOwners() {
        log.trace("Method is invoked");

        Flux<Owner> allOwners = ownerService.findAll();
        return ResponseEntity.ok(allOwners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Owner>> findOwnerById(@PathVariable("id") Long ownerId) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        Mono<Owner> ownerResponse = ownerService.findById(ownerId);
        return ResponseEntity.ok(ownerResponse);
    }

    @PostMapping()
    public ResponseEntity<OwnerResponseDTO> createOwner(@Valid @RequestBody OwnerCreateRequestDTO ownerCreateRequestDTO) {
        log.trace("Method is invoked");

        OwnerResponseDTO ownerResponseDTO = ownerService.create(ownerCreateRequestDTO);
        return ResponseEntity.status(CREATED).body(ownerResponseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OwnerResponseDTO> updateOwnerById(@PathVariable("id") Long ownerId,
                                                            @Valid @RequestBody OwnerUpdateRequestDTO updateDto) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        OwnerResponseDTO ownerResponseDTO = ownerService.updateById(ownerId, updateDto);

        return ResponseEntity.ok(ownerResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwnerById(@PathVariable("id") Long ownerId) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        ownerService.deleteById(ownerId);

        return ResponseEntity.noContent().build();
    }
}
