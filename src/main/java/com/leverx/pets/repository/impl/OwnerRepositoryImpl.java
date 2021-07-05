package com.leverx.pets.repository.impl;

import com.leverx.pets.config.MyDestinationProperties;
import com.leverx.pets.entity.Owner;
import com.leverx.pets.exception.RequestException;
import com.leverx.pets.repository.OwnerRepository;
import com.leverx.pets.repository.RequestExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
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
        OWNER_URL = destinationProperties.getDESTINATION_URI() + destinationProperties.getOWNER_RESOURCE_PATH();
    }

    @SuppressWarnings("unchecked")
    public List<Owner> findAll() throws RequestException {
        log.info("Beginning of the method");

        HttpResponse response = requestExecutor.executeRequest(new HttpGet(OWNER_URL));
        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(response);

        List<Owner> ownersList = requestExecutor.readValue(responseEntityString, List.class);

        log.info("Size of ownerList = {}", ownersList.size());
        return ownersList;
    }

    @Override
    public Owner findById(Long id) throws RequestException {
        log.info("Beginning of the method");

        HttpResponse httpResponse = requestExecutor.executeRequest(new HttpGet(OWNER_URL + "/" + id));

        String responseEntityString = requestExecutor.parseJsonFromHttpResponse(httpResponse);

        Owner owner = requestExecutor.readValue(responseEntityString, Owner.class);

        log.info("Owner by id = {}: {}", id, owner);
        return owner;
    }

    @Override
    public Owner save(Owner owner) {
        return null;
    }


}
