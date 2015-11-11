package com.example.controllers;

import com.example.clients.InstructorClient;
import com.example.models.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
@RequestMapping("/rest-template")
public class RestTemplateController {

    @Autowired
    InstructorClient instructorClient;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model) {

        model.addAttribute("title", "Standard RestTemplate");

        Collection<Instructor> instructorsList = instructorClient.findAll();
        model.addAttribute("instructors", instructorsList);

        return "views/standard-rest-template";

    }

}
