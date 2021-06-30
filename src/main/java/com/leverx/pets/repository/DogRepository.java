package com.leverx.pets.repository;

import com.leverx.pets.entity.Dog;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository{

    @NonNull
    List<Dog> findAll();
}
