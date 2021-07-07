package com.leverx.pets.repository.impl;

import com.leverx.pets.config.DestinationProperties;
import com.leverx.pets.dto.request.ExchangePetsRequestDTO;
import com.leverx.pets.repository.ExchangeRepository;
import com.leverx.pets.repository.RequestExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Repository
public class ExchangeRepositoryImpl implements ExchangeRepository {

    private final DestinationProperties destinationProperties;

    private final RequestExecutor requestExecutor;

    private String EXCHANGE_URL;

    @PostConstruct
    public void init() {
        EXCHANGE_URL = destinationProperties.getDESTINATION_URI() + destinationProperties.getEXCHANGE_RESOURCE_PATH();
    }

    @Override
    public void exchangePets(ExchangePetsRequestDTO exchangePetsRequestDTO) {
        requestExecutor.executePostRequest(new HttpPost(EXCHANGE_URL), exchangePetsRequestDTO);
    }
}
