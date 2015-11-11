package com.example.controllers;

import com.example.clients.InstructorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/feign")
public class FeignTestController {

    @Autowired
    InstructorClient client;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model) {

        model.addAttribute("title", "Feign Example");

//        model.addAttribute("instructors", client.getInstructors());

        return "feign";

    }

}
