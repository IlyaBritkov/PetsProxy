package com.leverx.pets.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePetResponseDTO implements Serializable {

    private Long id;

    private String breed;

    private String name;

    private Integer age;

    private Double weight;

    private Boolean isAlive;

    private Boolean isHealthy;

    private Long ownerId;
}
