package com.leverx.pets.service;

import com.leverx.pets.dto.request.ExchangePetsRequestDTO;
import com.leverx.pets.exception.EntityDoesNotExistException;
import com.leverx.pets.exception.ExchangeException;

public interface ExchangeService {

    void exchangePets(ExchangePetsRequestDTO exchangePetsRequest) throws ExchangeException, EntityDoesNotExistException;
}
