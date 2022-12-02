package com.daikichiroutes2.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiVariables {

    @RequestMapping("/travel/{city}")
    public String variableCity (
        @PathVariable("city") String cityName) {
            return "Congratulations! You will soon travel to " + cityName;
        }

    @RequestMapping("lotto/{number}")
    public String daikichiLotto (
        @PathVariable("number") Integer num) {
            if (num % 2 == 0) {
                return "You will take a grand journey in the near future, but be weary of tempting offers.";
            } else {
                return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
            }
        }

}
