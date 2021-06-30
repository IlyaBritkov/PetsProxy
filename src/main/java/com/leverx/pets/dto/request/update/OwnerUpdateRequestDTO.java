package com.leverx.pets.dto.request.update;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class OwnerUpdateRequestDTO {

    private String firstName;

    private String lastName;

    @Positive(message = "Should be greater than 0")
    private Integer age;

    private Boolean isAlive;

}
