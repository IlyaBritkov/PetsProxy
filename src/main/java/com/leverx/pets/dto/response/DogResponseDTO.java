package com.leverx.pets.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DogResponseDTO extends BasePetResponseDTO {

    private Boolean noseIsDry;
}
