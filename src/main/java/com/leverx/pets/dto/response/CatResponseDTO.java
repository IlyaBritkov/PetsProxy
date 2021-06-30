package com.leverx.pets.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CatResponseDTO extends BasePetResponseDTO {

    private Boolean isCastrated;
}
