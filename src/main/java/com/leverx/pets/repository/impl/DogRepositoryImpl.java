package com.leverx.pets.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.leverx.pets.config.MyDestinationProperties;
import com.leverx.pets.entity.Dog;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.repository.DogRepository;
import com.leverx.pets.repository.RequestExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Repository
public class DogRepositoryImpl implements DogRepository {

    private final MyDestinationProperties destinationProperties;

    private final RequestExecutor requestExecutor;

    private String DOGS_URL;

    @PostConstruct
    public void init() {
        DOGS_URL = destinationProperties.getDESTINATION_URI() + destinationProperties.getDOGS_RESOURCE_PATH();
    }

    public List<Dog> findAll() throws RequestException {
        log.info("Beginning of the method");

        HttpResponse response = requestExecutor.executeGetRequest(new HttpGet(DOGS_URL));
        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(response);

        List<Dog> dogsList = requestExecutor.readValue(responseEntityString, new TypeReference<>() {
        });

        log.info("Size of dogsList = {}", dogsList.size());

        return dogsList;
    }

    @Override
    public Dog findById(Long id) throws RequestException {
        log.info("Method is invoked");

        HttpResponse httpResponse = requestExecutor.executeGetRequest(new HttpGet(DOGS_URL + "/" + id));

        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(httpResponse);

        Dog dog = requestExecutor.readValue(responseEntityString, Dog.class);

        log.info("Dog by id = {}: {}", id, dog);
        return dog;
    }

    @Override
    public void save(Dog newDog) throws RequestException {
        log.info("Method is invoked");

        requestExecutor.executePostRequest(new HttpPost(DOGS_URL), newDog);
        log.info("Method completed");
    }

    @Override
    public Dog update(Dog dog) throws RequestException {
        log.info("Method is invoked");

        HttpResponse response = requestExecutor.executePatchRequest(new HttpPatch(DOGS_URL), dog);
        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(response);

        dog = requestExecutor.readValue(responseEntityString, Dog.class);

        log.info("Method completed. Updated dog: {}", dog);
        return dog;
    }

    @Override
    public void deleteById(Long id) throws RequestException {
        requestExecutor.executeDeleteRequest(new HttpDelete(DOGS_URL + "/" + id));
    }
}
