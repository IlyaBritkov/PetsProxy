package com.leverx.pets.config;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Collections;

import static io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class SpringConfig {

    @Bean
    public WebClient webClient() {
        int timeout = 10_000;
        HttpClient httpClient = HttpClient.create()
                .option(CONNECT_TIMEOUT_MILLIS, timeout)
                .responseTimeout(Duration.ofMillis(timeout))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(timeout, MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(timeout, MILLISECONDS)));

        return WebClient.builder()
                .baseUrl("https://my-pets.cfapps.eu10.hana.ondemand.com/api/v1")
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "https://my-pets.cfapps.eu10.hana.ondemand.com/api/v1"))
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
