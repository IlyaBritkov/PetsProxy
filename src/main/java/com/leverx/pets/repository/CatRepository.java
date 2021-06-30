package com.leverx.pets.repository;

import com.leverx.pets.entity.Cat;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository {

    @NonNull
    List<Cat> findAll();
}
