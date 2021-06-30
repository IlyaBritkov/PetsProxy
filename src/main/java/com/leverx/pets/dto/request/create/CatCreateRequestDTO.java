package com.leverx.pets.dto.request.create;

import com.leverx.pets.dto.request.BasePetRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class CatCreateRequestDTO extends BasePetRequestDTO {

    @NotNull(message = "Field is mandatory")
    private Boolean isCastrated;
}
