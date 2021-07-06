package com.leverx.pets.controller;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.exception.RequestException;
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

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@RestController
@RequestMapping(value = "api/v1/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping()
    public ResponseEntity<List<OwnerResponseDTO>> findAllOwners() throws RequestException {
        log.trace("Method is invoked");

        List<OwnerResponseDTO> allOwners = ownerService.findAll();
        return ResponseEntity.ok(allOwners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerResponseDTO> findOwnerById(@PathVariable("id") Long ownerId) throws RequestException {
        log.trace("Method is invoked");

        OwnerResponseDTO ownerResponse = ownerService.findById(ownerId);
        return ResponseEntity.ok(ownerResponse);
    }

    @PostMapping()
    public ResponseEntity<?> createOwner(@Valid @RequestBody OwnerCreateRequestDTO ownerCreateRequestDTO) throws RequestException {
        log.trace("Method is invoked");

        ownerService.create(ownerCreateRequestDTO);
        return new ResponseEntity<>(CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OwnerResponseDTO> updateOwnerById(@PathVariable("id") Long ownerId,
                                                            @Valid @RequestBody OwnerUpdateRequestDTO updateDto) throws RequestException {
        log.trace("Method is invoked");

        OwnerResponseDTO ownerResponseDTO = ownerService.updateById(ownerId, updateDto);

        return ResponseEntity.ok(ownerResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwnerById(@PathVariable("id") Long ownerId) throws RequestException {
        log.trace("Method is invoked");

        ownerService.deleteById(ownerId);

        return ResponseEntity.noContent().build();
    }
}
