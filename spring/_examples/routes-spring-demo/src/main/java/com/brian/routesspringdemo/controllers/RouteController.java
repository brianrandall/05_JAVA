package com.brian.routesspringdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    @GetMapping("/search")
    public String searchKeyword(@RequestParam(value = "q") String keyWordFromClient) {
        return "You searched for: " + keyWordFromClient;
    }

    // localhost:8080/search?name=name&age=age
    @GetMapping("/pet")
    public String getPet (
        @RequestParam("name") String name,
        @RequestParam("age") Integer age) {
        return "You have a pet named " + name + " who is " + age + " years old.";
    }

    // same thing with potentially null values
    @GetMapping("/optional/pet")
    public String oPet (
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "age", required = false) Integer age) {
        if (name == null) {
            return "name is not available";
        } else if (age == null) {
            return "age is not available";
        } else {
            return "You have a pet named " + name + " who is " + age + " years old.";
        }
    }

    // FYI the "m" is not required
    @GetMapping("/m/{name}/{color}")
    public String petWithColor (
        @PathVariable("name") String name,
        @PathVariable("color") String color) {
        return "You have a " + color + " pet named " + name;
    }
}
