package com.leverx.pets.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.leverx.pets.config.MyDestinationProperties;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.repository.OwnerRepository;
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
public class OwnerRepositoryImpl implements OwnerRepository {

    private final MyDestinationProperties destinationProperties;

    private final RequestExecutor requestExecutor;

    private String OWNER_URL;

    @PostConstruct
    public void init() {
        OWNER_URL = destinationProperties.getDESTINATION_URI() + destinationProperties.getOWNERS_RESOURCE_PATH();
    }

    public List<Owner> findAll() throws RequestException {
        log.info("Beginning of the method");

        HttpResponse response = requestExecutor.executeGetRequest(new HttpGet(OWNER_URL));
        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(response);

        List<Owner> ownersList = requestExecutor.readValue(responseEntityString, new TypeReference<>() {
        });

        log.info("Size of ownerList = {}", ownersList.size() + " Owners: " + ownersList); // TODO: 7/5/2021

        log.error(ownersList.getClass().getName()); // TODO: 7/5/2021
        return ownersList;
    }

    @Override
    public Owner findById(Long id) throws RequestException {
        log.info("Method is invoked");

        HttpResponse httpResponse = requestExecutor.executeGetRequest(new HttpGet(OWNER_URL + "/" + id));

        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(httpResponse);

        Owner owner = requestExecutor.readValue(responseEntityString, Owner.class);

        log.info("Owner by id = {}: {}", id, owner);
        return owner;
    }

    @Override
    public void save(Owner newOwner) throws RequestException {
        log.info("Method is invoked");

        requestExecutor.executePostRequest(new HttpPost(OWNER_URL), newOwner);
        log.info("Method completed");
    }

    @Override
    public Owner update(Owner owner) throws RequestException {
        log.info("Method is invoked");

        HttpResponse response = requestExecutor.executePatchRequest(new HttpPatch(OWNER_URL), owner);
        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(response);

        owner = requestExecutor.readValue(responseEntityString, Owner.class);

        log.info("Method completed. Updated owner: {}", owner);
        return owner;
    }

    @Override
    public void deleteById(Long id) throws RequestException {
        requestExecutor.executeDeleteRequest(new HttpDelete(OWNER_URL + "/" + id));
    }

}
