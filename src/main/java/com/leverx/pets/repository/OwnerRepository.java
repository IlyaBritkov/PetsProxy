package com.leverx.pets.repository;

import com.leverx.pets.entity.Owner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OwnerRepository {

    Flux<Owner> findAll();

    Mono<Owner> findById(Long id);

    Owner save(Owner owner);
}
