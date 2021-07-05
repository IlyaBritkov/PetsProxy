package com.leverx.pets.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MyDestinationProperties {

    @Getter
    @Value("${cf.destination.name}")
    private String DESTINATION_NAME;

    @Getter
    @Setter
    private String DESTINATION_URI;

    @Getter
    @Value("${cf.destination.api.resource.path.owners}")
    private String OWNER_RESOURCE_PATH;

    @Getter
    @Value("${cf.destination.api.resource.path.pets}")
    private String PETS_RESOURCE_PATH;

    @Getter
    @Value("${cf.destination.api.resource.path.cats}")
    private String CATS_RESOURCE_PATH;

    @Getter
    @Value("${cf.destination.api.resource.path.dogs}")
    private String DOGS_RESOURCE_PATH;

    @Getter
    @Value("${cf.destination.api.resource.path.exchange}")
    private String EXCHANGE_RESOURCE_PATH;

}
