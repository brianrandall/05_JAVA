package com.assignments.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class HomeController {

    @GetMapping("")
    public String index() {
        return "theform.jsp";
    }

    @PostMapping("/form/process")
    public String process(
        @RequestParam(value="number") int number,
        @RequestParam(value="city") String city,
        @RequestParam(value="person") String person,
        @RequestParam(value="activity") String activity,
        @RequestParam(value="livingThing") String livingThing,
        @RequestParam(value="niceThing") String niceThing,
        HttpSession session) {
            session.setAttribute("number", number);
            session.setAttribute("city", city);
            session.setAttribute("person", person);
            session.setAttribute("activity", activity);
            session.setAttribute("livingThing", livingThing);
            session.setAttribute("niceThing", niceThing);
            return "redirect:/omikuji/show";
    }

    @GetMapping("/show")
    public String show() {
        return "theformResults.jsp";
    }

}
