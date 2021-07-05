package com.leverx.pets.controller;

import com.leverx.pets.dto.request.create.DogCreateRequestDTO;
import com.leverx.pets.dto.request.update.DogUpdateRequestDTO;
import com.leverx.pets.dto.response.DogResponseDTO;
import com.leverx.pets.service.DogService;
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
@RequestMapping("api/v1/dogs")
public class DogController {
    private final DogService dogService;

    @GetMapping()
    public ResponseEntity<List<DogResponseDTO>> findAllDogs() {
        log.trace("Method is invoked");

        List<DogResponseDTO> allDogs = dogService.findAll();
        return ResponseEntity.ok(allDogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DogResponseDTO> findDogById(@PathVariable("id") Long dogId) {
        log.trace("Method is invoked");

        DogResponseDTO dogResponseDTO = dogService.findById(dogId);
        return ResponseEntity.ok(dogResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<DogResponseDTO> createDog(@Valid @RequestBody DogCreateRequestDTO dogCreateRequestDTO) {
        log.trace("Method is invoked");

        DogResponseDTO dogResponseDTO = dogService.create(dogCreateRequestDTO);
        return ResponseEntity.status(CREATED).body(dogResponseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DogResponseDTO> updateDogById(@PathVariable("id") Long dogId,
                                                        @Valid @RequestBody DogUpdateRequestDTO updateDto) {
        log.trace("Method is invoked");

        DogResponseDTO dogResponseDTO = dogService.updateById(dogId, updateDto);

        return ResponseEntity.ok(dogResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDogById(@PathVariable("id") Long dogId){
        log.trace("Method is invoked");

        dogService.deleteById(dogId);

        return ResponseEntity.noContent().build();
    }
}
