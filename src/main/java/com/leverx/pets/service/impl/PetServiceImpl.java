package com.leverx.pets.service.impl;

import com.leverx.pets.dto.response.BasePetResponseDTO;
import com.leverx.pets.dto.response.CatResponseDTO;
import com.leverx.pets.dto.response.DogResponseDTO;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.service.CatService;
import com.leverx.pets.service.DogService;
import com.leverx.pets.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class PetServiceImpl implements PetService {

    private final DogService dogService;

    private final CatService catService;

    @Override
    public List<BasePetResponseDTO> findAll() throws RequestException {

        List<DogResponseDTO> allDogs = dogService.findAll();
        List<CatResponseDTO> allCats = catService.findAll();

        List<BasePetResponseDTO> allPets = new ArrayList<>();

        allPets.addAll(allDogs);
        allPets.addAll(allCats);

        return allPets;
    }
}
