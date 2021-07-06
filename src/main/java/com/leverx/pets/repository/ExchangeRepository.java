package com.leverx.pets.repository;

import com.leverx.pets.dto.request.ExchangePetsRequestDTO;
import com.leverx.pets.exception.RequestException;

public interface ExchangeRepository {

    void exchangePets(ExchangePetsRequestDTO exchangePetsRequestDTO) throws RequestException;
}
