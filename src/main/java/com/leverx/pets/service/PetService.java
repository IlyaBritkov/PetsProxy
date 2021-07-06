package com.leverx.pets.service;

import com.leverx.pets.dto.response.BasePetResponseDTO;
import com.leverx.pets.exception.RequestException;

import java.util.List;

public interface PetService {

    List<BasePetResponseDTO> findAll() throws RequestException;

}
