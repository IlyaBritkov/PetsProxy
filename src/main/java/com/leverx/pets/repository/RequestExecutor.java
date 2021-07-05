package com.leverx.pets.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leverx.pets.exception.RequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.BAD_GATEWAY;

@AllArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@Component
public class RequestExecutor {

    private final HttpClient httpClient;

    private final ObjectMapper objectMapper;


    public HttpResponse executeGetRequest(HttpUriRequest request) throws RequestException {
        return executeRequest(request);
    }

    public HttpResponse executePostRequest(HttpPost request, Object object) throws RequestException {
        try {
            String jsonString = objectMapper.writeValueAsString(object);

            request.setEntity(new StringEntity(jsonString, APPLICATION_JSON));

            return executeRequest(request);
        } catch (IOException e) {
            log.error("Exception: {}", e.getMessage());
            throw new RequestException("Something goes wrong. Please try again later.", BAD_GATEWAY);
        }
    }

    protected HttpResponse executeRequest(HttpUriRequest request) throws RequestException {
        try {
            HttpResponse httpResponse = httpClient.execute(request);

            StatusLine responseStatusLine = httpResponse.getStatusLine();
            int statusCode = responseStatusLine.getStatusCode();

            if (statusCode < 200 || statusCode >= 300) {
                throw new RequestException(responseStatusLine.getReasonPhrase(), HttpStatus.valueOf(statusCode));
            }

            return httpResponse;
        } catch (IOException e) {
            log.error("Exception: {}", e.getMessage());
            throw new RequestException("Something goes wrong. Please try again later.", BAD_GATEWAY);
        }
    }

    public String parseJsonFromHttpResponse(HttpResponse httpResponse) throws RequestException {
        HttpEntity entity = httpResponse.getEntity();
        return parseJsonFromResponseEntity(entity);
    }

    public String parseJsonFromResponseEntity(HttpEntity responseEntity) throws RequestException {
        try {
            return EntityUtils.toString(responseEntity);
        } catch (IOException e) {
            log.error("Exception: {}", e.getMessage());
            throw new RequestException("Something goes wrong. Please try again later.", BAD_GATEWAY);
        }
    }

    public <T> T readValue(String content, Class<T> valueType) throws RequestException {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            log.error("Exception: {}", e.getMessage());
            throw new RequestException("Something goes wrong. Please try again later.", BAD_GATEWAY);
        }
    }

}
