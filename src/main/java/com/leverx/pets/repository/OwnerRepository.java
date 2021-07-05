package com.leverx.pets.repository;

import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.RequestException;

import java.util.List;

public interface OwnerRepository {

    List<Owner> findAll() throws RequestException;

    Owner findById(Long id) throws RequestException;

    Owner save(Owner owner);
}
