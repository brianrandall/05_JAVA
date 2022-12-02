package com.brian.routesspringdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class ApiController {

    //request method defaults to GET
    @RequestMapping("/option/1")
    public String option1() {
        return "option 1 has been requested";
    }

    //explicitly set request method to GET
    @RequestMapping(value = "/option/2", method = RequestMethod.POST)
    public String option2() {
        return "option 2 has been requested";
    }

    //explicitly set request method to GET with @GetMapping
    @GetMapping("/option/3")
    public String option3() {
        return "option 3 has been requested";
    }
    
}
