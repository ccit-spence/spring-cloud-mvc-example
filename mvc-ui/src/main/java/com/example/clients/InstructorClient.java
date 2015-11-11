package com.example.clients;

import com.example.models.Instructor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Component
public class InstructorClient {

    @Autowired
    RestTemplate restTemplate;

    public Collection<String> getInstructorsFallback() {
        return Collections.emptyList();
    }

    @HystrixCommand(fallbackMethod = "getInstructorsFallback")
    public Collection<Instructor> findAll() {

        String url = "http://rest-api/instructors?page={page}&size={size}";

        ResponseEntity<PagedResources<Instructor>> responseEntity = restTemplate.exchange(
            url, HttpMethod.GET, null,
            new ParameterizedTypeReference<PagedResources<Instructor>>() {}, 0, 10);

        Collection<Instructor> resources = responseEntity.getBody().getContent();

        return new ArrayList<>(resources);
    }

}
