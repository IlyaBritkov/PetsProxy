package com.leverx.pets.service.impl;

import com.leverx.pets.dto.request.ExchangePetsRequestDTO;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.repository.ExchangeRepository;
import com.leverx.pets.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;

    @Override
    public void exchangePets(ExchangePetsRequestDTO exchangePetsRequest) throws RequestException {
        log.trace("Method is invoked");

        exchangeRepository.exchangePets(exchangePetsRequest);

        log.debug("Exchange is completed successfully");
    }


}
