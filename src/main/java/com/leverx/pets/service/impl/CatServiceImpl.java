package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.create.CatCreateRequestDTO;
import com.leverx.pets.dto.request.update.CatUpdateRequestDTO;
import com.leverx.pets.dto.response.CatResponseDTO;
import com.leverx.pets.entity.Cat;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.mapper.CatMapper;
import com.leverx.pets.repository.CatRepository;
import com.leverx.pets.service.CatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    private final CatMapper catMapper;

    @Override
    public List<CatResponseDTO> findAll() {

        List<Cat> allCats = catRepository.findAll();

        log.debug("Amount of all cats = {}", allCats.size());

        return allCats.stream()
                .map(catMapper::toResponseDTO)
                .collect(toList());
    }

    @Override
    public CatResponseDTO findById(Long id) {

        Cat catById = findEntityById(id);

        log.debug("Cat by id = {} was found: {}", id, catById);

        return catMapper.toResponseDTO(catById);
    }

    @Override
    public Cat findEntityById(Long id) {

        return catRepository.findById(id);
    }

    @Override
    public void create(CatCreateRequestDTO catRequestDTO) {

        Cat newCat = catMapper.toEntity(catRequestDTO);
        catRepository.save(newCat);
    }

    @Override
    public CatResponseDTO updateById(Long id, CatUpdateRequestDTO catUpdateRequestDTO) {

        Cat catById = findEntityById(id);

        catMapper.updateEntity(catUpdateRequestDTO, catById);

        catRepository.update(catById);

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

        catRepository.deleteById(id);
        log.debug("Cat by id = {} was deleted", id);
    }
}
