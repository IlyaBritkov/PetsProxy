package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.create.CatCreateRequestDTO;
import com.leverx.pets.dto.request.update.CatUpdateRequestDTO;
import com.leverx.pets.dto.response.CatResponseDTO;
import com.leverx.pets.entity.Cat;
import com.leverx.pets.exception.EntityDoesNotExistException;
import com.leverx.pets.mapper.CatMapper;
import com.leverx.pets.repository.CatRepository;
import com.leverx.pets.service.CatService;
import com.leverx.pets.service.EntityCheckExistenceService;
import com.leverx.pets.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    private final EntityCheckExistenceService entityCheckExistenceService;

    private final CatMapper catMapper;

    private final OwnerService ownerService;

    @Override
    public List<CatResponseDTO> findAll() {
        log.trace("Method is invoked");

        List<Cat> allCats = catRepository.findAll();

        log.debug("Amount of all cats = {}", allCats.size());

        return allCats.stream()
                .map(catMapper::toResponseDTO)
                .collect(toList());
    }

    @Override
    public CatResponseDTO findById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        Cat catById = findEntityById(id);

        log.debug("Cat by id = {} was found: {}", id, catById);

        return catMapper.toResponseDTO(catById);
    }

    @Override
    public Cat findEntityById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

//        return catRepository.findById(id)
//                .orElseThrow(() -> new EntityDoesNotExistException(String.format("Cat with id = %d doesnt exists", id)
//                        , NOT_FOUND));

        return null;
    }

    @Override
    public CatResponseDTO create(CatCreateRequestDTO catRequestDTO) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

//        Long requestOwnerId = catRequestDTO.getOwnerId();
//        entityCheckExistenceService.checkOwnerExistenceById(requestOwnerId);
//
//        Owner ownerById = ownerService.findEntityById(requestOwnerId);
//
//        Cat newCat = catMapper.toEntity(catRequestDTO);
//        newCat.setOwner(ownerById);
//        catRepository.save(newCat);
//
//        log.debug("New cat was created and saved: {}", newCat);
//
//        return catMapper.toResponseDTO(newCat);
        return null;
    }

    @Override
    public CatResponseDTO updateById(Long id, CatUpdateRequestDTO catUpdateRequestDTO) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

        if (!existsById(id)) {
            throw new EntityDoesNotExistException(String.format("Cat with id = %d doesnt exists", id),
                    NOT_FOUND);
        }

        Long requestOwnerId = catUpdateRequestDTO.getOwnerId();

        if (requestOwnerId != null) {
            entityCheckExistenceService.checkOwnerExistenceById(requestOwnerId);
        }

        Cat catById = findEntityById(id);

        catMapper.updateEntity(catUpdateRequestDTO, catById);

        log.debug("Cat by id = {} was updated: {}", id, catById);

        return catMapper.toResponseDTO(catById);
    }

    @Override
    public boolean existsById(Long id) {
        log.trace("Method is invoked");

        boolean isCatExistsById = entityCheckExistenceService.isCatExistsById(id);

        log.debug("Is cat by id = {} exists:{}", id, isCatExistsById);

        return isCatExistsById;
    }

    @Override
    public void deleteById(Long id) throws EntityDoesNotExistException {
        log.trace("Method is invoked");

//        try {
//            catRepository.deleteById(id);
//        } catch (EmptyResultDataAccessException ex) {
//            throw new EntityDoesNotExistException(String.format("Cat with id = %d doesnt exists", id),
//                    NOT_FOUND);
//        }


        log.debug("Cat by id = {} was deleted", id);
    }
}
