package com.leverx.pets.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@NoArgsConstructor
@Data
public abstract class BasePetRequestDTO {

    private String breed;

    private String name;

    @PositiveOrZero(message = "Should be greater or equals than 0")
    private Integer age;

    @Positive(message = "Should be greater than 0")
    private Double weight;

    private Boolean isAlive;

    private Boolean isHealthy;

    @Positive(message = "Should be greater than 0")
    private Long ownerId;
}
