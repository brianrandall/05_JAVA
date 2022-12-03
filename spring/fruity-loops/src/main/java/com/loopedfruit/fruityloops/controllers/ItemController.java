package com.loopedfruit.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loopedfruit.fruityloops.models.Item;

@Controller
public class ItemController {
    
    @RequestMapping("/item")
    public String index(Model model) {

        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Apple", 1.99));
        fruits.add(new Item("Orange", 199.99));
        fruits.add(new Item("Banana", 875.99));
        fruits.add(new Item("Grape", 3.29));
        fruits.add(new Item("Strawberry", .99));
        fruits.add(new Item("Blueberry", 47.99));
        fruits.add(new Item("Raspberry", 1.96));
        fruits.add(new Item("Pineapple", 3.37));

        model.addAttribute("fruitsFromController", fruits);

        return "index.jsp";
    }

}
