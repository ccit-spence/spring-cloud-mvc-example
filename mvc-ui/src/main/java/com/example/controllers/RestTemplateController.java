package com.example.controllers;


import com.example.models.Instructor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/rest-template")
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model) {

        model.addAttribute("title", "Standard RestTemplate");

        /**
         * Autowired RestTemplate
         */

        String url = "http://rest-api/instructors?page={page}&size={size}";

        ResponseEntity<PagedResources<Instructor>> responseEntity = restTemplate.exchange(
            url, HttpMethod.GET, null,
            new ParameterizedTypeReference<PagedResources<Instructor>>() {}, 0, 10);

        PagedResources<Instructor> resources = responseEntity.getBody();

        List<Instructor> instructorsList = new ArrayList<>(resources.getContent());

        model.addAttribute("instructors", instructorsList);

        /**
         * Custom RestTemplate
         */

        String customUrl = "http://localhost:8085/instructors?page={page}&size={size}";

        RestTemplate customRestTemplate = restTemplate();

        ResponseEntity<PagedResources<Instructor>> responseEntityCustom = customRestTemplate.exchange(
            customUrl, HttpMethod.GET, null,
            new ParameterizedTypeReference<PagedResources<Instructor>>() {}, 0, 10);

        PagedResources<Instructor> resourcesCustom = responseEntityCustom.getBody();

        List<Instructor> customInstructorsList = new ArrayList<>(resourcesCustom.getContent());

        model.addAttribute("customInstructors", customInstructorsList);

        return "views/standard-rest-template";

    }

    private RestTemplate restTemplate() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new Jackson2HalModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setObjectMapper(mapper);
        return new RestTemplate(Arrays.asList(converter));
    }

}
