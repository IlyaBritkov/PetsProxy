package com.leverx.pets.repository.impl;

import com.leverx.pets.entity.Pet;
import com.leverx.pets.repository.PetRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepositoryImpl implements PetRepository {
    @Override
    public List<Pet> findAll() {
        return null;
    }
}
