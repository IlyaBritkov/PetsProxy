package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.create.DogCreateRequestDTO;
import com.leverx.pets.dto.request.update.DogUpdateRequestDTO;
import com.leverx.pets.dto.response.DogResponseDTO;
import com.leverx.pets.entity.Dog;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.mapper.DogMapper;
import com.leverx.pets.repository.DogRepository;
import com.leverx.pets.service.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    private final DogMapper dogMapper;

    @Override
    public List<DogResponseDTO> findAll() {

        List<Dog> allDogs = dogRepository.findAll();

        log.debug("Amount of all dogs = {}", allDogs.size());

        return allDogs.stream()
                .map(dogMapper::toResponseDTO)
                .collect(toList());
    }

    @Override
    public DogResponseDTO findById(Long id) {

        Dog dogById = findEntityById(id);

        log.debug("Dog by id = {} was found: {}", id, dogById);

        return dogMapper.toResponseDTO(dogById);
    }

    @Override
    public Dog findEntityById(Long id) {

        return dogRepository.findById(id);
    }

    @Override
    public void create(DogCreateRequestDTO dogRequestDTO) {

        Dog newDog = dogMapper.toEntity(dogRequestDTO);
        dogRepository.save(newDog);
    }

    @Override
    public DogResponseDTO updateById(Long id, DogUpdateRequestDTO dogUpdateRequestDTO) {

        Dog dogById = findEntityById(id);

        dogMapper.updateEntity(dogUpdateRequestDTO, dogById);

        dogRepository.update(dogById);

        return findById(id);
    }

    @Override
    public boolean existsById(Long id) {

        boolean isExists;
        try {
            findById(id);
            isExists = true;
        } catch (RequestException e) {
            isExists = false;
        }
        log.debug("Cat by id = {} exists: {}", id, isExists);

        return isExists;
    }

    @Override

    public void deleteById(Long id) {

        dogRepository.deleteById(id);
        log.debug("Cat by id = {} was deleted", id);
    }
}