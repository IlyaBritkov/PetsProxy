package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.create.OwnerCreateRequestDTO;
import com.leverx.pets.dto.request.update.OwnerUpdateRequestDTO;
import com.leverx.pets.dto.response.OwnerResponseDTO;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.mapper.OwnerMapper;
import com.leverx.pets.repository.OwnerRepository;
import com.leverx.pets.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper;

    @Override
    public List<OwnerResponseDTO> findAll() throws RequestException {
        log.trace("Method is invoked");

        return ownerRepository.findAll()
                .stream()
                .map(ownerMapper::toResponseDTO)
                .collect(toList());
    }

    @Override
    public OwnerResponseDTO findById(Long id) throws RequestException {
        log.trace("Method is invoked");

        Owner ownerById = findEntityById(id);

        return ownerMapper.toResponseDTO(ownerById);
    }

    @Override
    public Owner findEntityById(Long id) throws RequestException {
        log.trace("Method is invoked");

        Owner ownerById = ownerRepository.findById(id);
        log.debug("Owner by id = {} was found: {}", id, ownerById);

        return ownerById;
    }

    @Override
    public void create(OwnerCreateRequestDTO ownerRequestDTO) throws RequestException {
        log.trace("Method is invoked");

        Owner newOwner = ownerMapper.toEntity(ownerRequestDTO);
        ownerRepository.save(newOwner);
    }

    @Override
    public OwnerResponseDTO updateById(Long id, OwnerUpdateRequestDTO ownerUpdateRequestDTO) throws RequestException {
        log.trace("Method is invoked");

        Owner ownerById = findEntityById(id);

        ownerMapper.updateEntity(ownerUpdateRequestDTO, ownerById);

        ownerRepository.update(ownerById);

        return findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        log.trace("Method is invoked");

        boolean isExists;
        try {
            findById(id);
            isExists = true;
        } catch (RequestException e) {
            isExists = false;
        }
        log.debug("Owner by id = {} exists: {}", id, isExists);

        return isExists;
    }

    @Override
    public void deleteById(Long id) throws RequestException {
        log.trace("Method is invoked");

        ownerRepository.deleteById(id);
        log.debug("Owner by id = {} was deleted", id);
    }
}
