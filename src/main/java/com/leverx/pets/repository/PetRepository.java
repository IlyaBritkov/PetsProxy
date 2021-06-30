package com.leverx.pets.repository;

import com.leverx.pets.entity.Pet;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository {

    @NonNull
    List<Pet> findAll();
}
