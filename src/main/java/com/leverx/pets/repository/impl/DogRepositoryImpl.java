package com.leverx.pets.repository.impl;

import com.leverx.pets.entity.Dog;
import com.leverx.pets.repository.DogRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogRepositoryImpl implements DogRepository {
    @Override
    public List<Dog> findAll() {
        return null;
    }
}
