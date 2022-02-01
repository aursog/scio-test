package com.scio.test.framework.restclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scio.test.framework.domain.CMSDataInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
public class CMSDataRestClient {

    private RestTemplate restTemplate;
    private String url;
    private ObjectMapper objectMapper;

    public CMSDataRestClient(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.objectMapper = new ObjectMapper();
    }

    @Cacheable("jsonResponse")
    public List<CMSDataInput> get() {
        ResponseEntity<String> jsonResponse = restTemplate.getForEntity(url, String.class);

        try {
            return objectMapper.readValue(jsonResponse.getBody(), new TypeReference<List<CMSDataInput>>() {});
        } catch (JsonProcessingException jsonException) {
            log.error(jsonException.getMessage());
            return null;
        }
    }
}
