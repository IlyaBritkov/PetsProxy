package com.leverx.pets.repository;

import com.leverx.pets.entity.Dog;
import com.leverx.pets.exception.RequestException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository{

    List<Dog> findAll() throws RequestException;

    Dog findById(Long id) throws RequestException;

    void save(Dog dog) throws RequestException;

    Dog update(Dog dog) throws RequestException;

    void deleteById(Long id) throws RequestException;
}
