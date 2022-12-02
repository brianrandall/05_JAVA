package com.springproject.hellohuman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HumanController {

    public String result;
    
    @GetMapping("/")
    public String human (
        @RequestParam(value="name", required=false) String name,
        @RequestParam(value="last_name", required=false) String last_name,
        @RequestParam(value="times", required=false) Integer times) {
        
        if (name == null && last_name == null && times == null) {
            return "Hello Human!";
        } else if (name != null && last_name == null && times == null) {
            return "Hello " + name + "!";
        } else if (name == null && last_name != null && times == null) {
            return "Hello " + last_name + "!";
        } else if (name != null && last_name != null && times == null) {
            return "Hello " + name + " " + last_name + "!";
        } else if (times != null) {
            String result = "";
            for (int i = 0; i < times; i++) {
                result += "Hello " + name + " " + last_name + "! ";
            }
            return result;
        } else {
            return "Hello Human!";
        }
    }
}
