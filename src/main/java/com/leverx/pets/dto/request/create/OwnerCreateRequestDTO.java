package com.leverx.pets.dto.request.create;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class OwnerCreateRequestDTO {

    private String firstName;

    private String lastName;

    @Positive(message = "Should be greater than 0")
    private Integer age;

    private Boolean isAlive;
}
