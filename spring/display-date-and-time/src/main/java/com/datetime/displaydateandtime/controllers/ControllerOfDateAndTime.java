package com.datetime.displaydateandtime.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerOfDateAndTime {

    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }

    @GetMapping("/date")
    public String date(Model model) {
        Date date = new Date();

        model.addAttribute("date", date);
        model.addAttribute("alert", "<script>alert('This is the date page')</script>");
        return "date.jsp";
    }

    @GetMapping("/time")
    public String time(Model model) {
        Date date = new Date();

        model.addAttribute("date", date);
        model.addAttribute("alert", "<script>alert('This is the time page')</script>");
        return "time.jsp";
    }
    
}
