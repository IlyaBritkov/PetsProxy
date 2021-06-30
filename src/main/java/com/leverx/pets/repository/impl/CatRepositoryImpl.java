package com.leverx.pets.repository.impl;

import com.leverx.pets.entity.Cat;
import com.leverx.pets.repository.CatRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepositoryImpl implements CatRepository {
    @Override
    public List<Cat> findAll() {
        return null;
    }
}
