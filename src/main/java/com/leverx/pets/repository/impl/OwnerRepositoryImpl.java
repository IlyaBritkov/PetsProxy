package com.leverx.pets.repository.impl;

import com.leverx.pets.entity.Owner;
import com.leverx.pets.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;

@RequiredArgsConstructor(onConstructor_ = @Autowired)

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
    private final WebClient client;

    @Override
    public Flux<Owner> findAll() {
//        RequestHeadersSpec<> requestHeadersSpec = client.get();
//        UriSpec<RequestBodySpec> uriSpec = client.get();
//
//        RequestBodySpec bodySpec = uriSpec.uri("/resource");


        Flux<Owner> employeeFlux = client.get()
                .uri("/owners")
                .retrieve()
                .bodyToFlux(Owner.class);

        employeeFlux.subscribe(System.out::println);

        return employeeFlux;
    }

    @Override
    public Mono<Owner> findById(Long id) {
        Mono<Owner> ownerMono = client.get()
                .uri("/owners/{id}", id)
                .retrieve()
                .bodyToMono(Owner.class);

        ownerMono.subscribe(System.out::println);

        return ownerMono;
    }

    @Override
    public Owner save(Owner owner) {
        UriSpec<RequestBodySpec> uriSpec = client.post();


        RequestBodySpec bodySpec = uriSpec.uri("/resource");

//        RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("data");

        LinkedMultiValueMap map = new LinkedMultiValueMap();
        map.add("key1", "value1");
        map.add("key2", "value2");
        RequestHeadersSpec<?> headersSpec = bodySpec.body(
                BodyInserters.fromMultipartData(map));

        ResponseSpec responseSpec = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();
        return null;
    }


}
