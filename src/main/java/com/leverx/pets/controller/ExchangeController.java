package com.leverx.pets.controller;

import com.leverx.pets.dto.request.ExchangePetsRequestDTO;
import com.leverx.pets.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@RestController
@RequestMapping("api/v1/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping("/pets")
    public ResponseEntity<?> exchangePets(@Valid @RequestBody ExchangePetsRequestDTO exchangePetsRequest) {
        log.trace("Method is invoked");

        exchangeService.exchangePets(exchangePetsRequest);

        return ResponseEntity.noContent().build();
    }
}
