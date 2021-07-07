package com.leverx.pets.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.leverx.pets.config.DestinationProperties;
import com.leverx.pets.entity.Cat;
import com.leverx.pets.repository.CatRepository;
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
public class CatRepositoryImpl implements CatRepository {

    private final DestinationProperties destinationProperties;

    private final RequestExecutor requestExecutor;

    private String CATS_URL;

    @PostConstruct
    public void init() {
        CATS_URL = destinationProperties.getDESTINATION_URI() + destinationProperties.getCATS_RESOURCE_PATH();
    }

    public List<Cat> findAll() {

        HttpResponse response = requestExecutor.executeGetRequest(new HttpGet(CATS_URL));
        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(response);

        List<Cat> catsList = requestExecutor.readValue(responseEntityString, new TypeReference<>() {
        });

        log.info("Size of catsList = {}", catsList.size());

        return catsList;
    }

    @Override
    public Cat findById(Long id) {

        HttpResponse httpResponse = requestExecutor.executeGetRequest(new HttpGet(CATS_URL + "/" + id));

        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(httpResponse);

        Cat cat = requestExecutor.readValue(responseEntityString, Cat.class);

        log.info("Cat by id = {}: {}", id, cat);
        return cat;
    }

    @Override
    public void save(Cat newCat) {
        requestExecutor.executePostRequest(new HttpPost(CATS_URL), newCat);
    }

    @Override
    public Cat update(Cat cat) {

        Long catId = cat.getId();
        HttpResponse response = requestExecutor.executePatchRequest(new HttpPatch(CATS_URL + "/" + catId), cat);
        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(response);

        cat = requestExecutor.readValue(responseEntityString, Cat.class);

        log.info("Method completed. Updated cat: {}", cat);
        return cat;
    }

    @Override
    public void deleteById(Long id) {
        requestExecutor.executeDeleteRequest(new HttpDelete(CATS_URL + "/" + id));
    }
}
