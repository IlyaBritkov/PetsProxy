package com.leverx.pets.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ExchangePetsRequestDTO {

    @NotNull(message = "Field is mandatory")
    @Positive(message = "Should be greater than 0")
    private Long firstPetId;

    @NotNull(message = "Field is mandatory")
    @Positive(message = "Should be greater than 0")
    private Long secondPetId;
}
