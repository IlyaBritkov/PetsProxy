package com.leverx.pets.service;

import com.leverx.pets.dto.request.ExchangePetsRequestDTO;
import com.leverx.pets.exception.RequestException;

public interface ExchangeService {

    void exchangePets(ExchangePetsRequestDTO exchangePetsRequest) throws RequestException;
}
