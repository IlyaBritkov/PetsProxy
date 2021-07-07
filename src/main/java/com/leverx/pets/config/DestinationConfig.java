package com.leverx.pets.config;

import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor(onConstructor_ = @Autowired)

@Configuration
public class DestinationConfig {

    private final DestinationProperties destinationProperties;

    @Bean
    public HttpDestination httpDestination() {
        HttpDestination httpDestination = DestinationAccessor.getDestination(destinationProperties.getDESTINATION_NAME()).asHttp();
        destinationProperties.setDESTINATION_URI(httpDestination.getUri().toString());

        return httpDestination;
    }

    @Bean
    public HttpClient httpClient() {
        HttpDestination destination = httpDestination();
        return HttpClientAccessor.getHttpClient(destination);
    }
}
