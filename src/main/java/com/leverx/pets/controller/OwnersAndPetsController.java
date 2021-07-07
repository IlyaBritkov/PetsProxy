package com.leverx.pets.controller;

import com.leverx.pets.dto.response.BasePetResponseDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.service.OwnerService;
import com.leverx.pets.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@RestController
@RequestMapping(value = "api/v1")
public class OwnersAndPetsController {

    private final OwnerService ownerService;

    private final PetService petService;

    @GetMapping("/all")
    public ResponseEntity<List<List<?>>> findAll() {

        List<OwnerResponseDTO> allOwners = ownerService.findAll();
        List<BasePetResponseDTO> allPets = petService.findAll();

        List<List<?>> all = new ArrayList<>();

        all.add(allOwners);
        all.add(allPets);

        return ResponseEntity.ok(all);
    }
}
