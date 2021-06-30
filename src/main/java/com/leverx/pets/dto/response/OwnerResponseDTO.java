package com.leverx.pets.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OwnerResponseDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private Boolean isAlive;

    List<Long> petIds;
}
