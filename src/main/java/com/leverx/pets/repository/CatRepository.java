package com.leverx.pets.repository;

import com.leverx.pets.entity.Cat;
import com.leverx.pets.exception.RequestException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository {

    List<Cat> findAll() throws RequestException;

    Cat findById(Long id) throws RequestException;

    void save(Cat cat) throws RequestException;

    Cat update(Cat cat) throws RequestException;

    void deleteById(Long id) throws RequestException;
}
