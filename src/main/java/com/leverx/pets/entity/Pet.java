package com.leverx.pets.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pet {

    private Long id;

    private String breed;

    private String name;

    private Integer age;

    private Double weight;

    @NotNull
    private Boolean isAlive = true;

    private Boolean isHealthy;

    private Owner owner;

}
