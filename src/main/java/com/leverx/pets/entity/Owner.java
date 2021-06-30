package com.leverx.pets.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Owner {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private Boolean isAlive;

    private List<Pet> pets = new ArrayList<>();

    @Builder
    public Owner(String firstName, String lastName, Integer age, Boolean isAlive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isAlive = isAlive == null || isAlive;
    }
}
