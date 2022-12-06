package com.assignments.ninjagoldgame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gold")
public class GameController {
    
    @GetMapping("")
    public String index() {
        return "index.jsp";
    }
    @SuppressWarnings("unchecked")
    @PostMapping("/process")
    public String process(
        @RequestParam("building") String building,
        HttpSession session) {
        ArrayList<String> activitiesList = new ArrayList<>();
        Date date = new Date();

        if (session.getAttribute("goldAmount") == null) {
            session.setAttribute("goldAmount", 0);
            session.setAttribute("activities", activitiesList);
        }

        if ((int)session.getAttribute("goldAmount") > -30) {
        
        if(building.equals("farm")) {
            
            Random r = new Random();
            int low = 10;
            int high = 20;
            int result = r.nextInt(high-low) + low;
            session.setAttribute("goldAmount", (int)session.getAttribute("goldAmount") + result);
            
            activitiesList = (ArrayList<String>) session.getAttribute("activities");
            activitiesList.add(0, "you went to the farm and got " + result + " gold " + "(" + date + ")");
            session.setAttribute("activities", activitiesList);

        }

        else if(building.equals("cave")) {
            Random r = new Random();
            int low = 5;
            int high = 10;
            int result = r.nextInt(high-low) + low;
            session.setAttribute("goldAmount", (int)session.getAttribute("goldAmount") + result);

            activitiesList = (ArrayList<String>) session.getAttribute("activities");
            activitiesList.add(0, "you went to a cave and got " + result + " gold " + "(" + date + ")");
            session.setAttribute("activities", activitiesList);
            
        }

        else if(building.equals("house")) {
            Random r = new Random();
            int low = 2;
            int high = 5;
            int result = r.nextInt(high-low) + low;
            session.setAttribute("goldAmount", (int)session.getAttribute("goldAmount") + result);

            activitiesList = (ArrayList<String>) session.getAttribute("activities");
            activitiesList.add(0, "you went into a house and got " + result + " gold " + "(" + date + ")");
            session.setAttribute("activities", activitiesList);
            
        }

        else if(building.equals("spa")) {
            Random r = new Random();
            int low = 5;
            int high = 20;
            int result = r.nextInt(high-low) + low;
            session.setAttribute("goldAmount", (int)session.getAttribute("goldAmount") - result);

            activitiesList = (ArrayList<String>) session.getAttribute("activities");
            activitiesList.add(0, "~you relaxed in the spa~ that cost " + result + " gold " + "(" + date + ")");
            session.setAttribute("activities", activitiesList);
            
        }

        else if(building.equals("isQuest")) {
            Random r = new Random();
            int low = -50;
            int high = 50;
            int result = r.nextInt(high-low) + low;
            session.setAttribute("goldAmount", (int)session.getAttribute("goldAmount") + result);

            activitiesList = (ArrayList<String>) session.getAttribute("activities");
            if (result > 0) {
            activitiesList.add(0, "you went on a quest and got " + result + " gold " + "(" + date + ")");
            } else {
                activitiesList.add(0, "you lost the quest and lost " + (result * -1) + " gold " + "(" + date + ")");
            }
            session.setAttribute("activities", activitiesList);
            
        }

        return "redirect:/gold";
    } else {
        return "redirect:/gold/debt/jail/sorry/bummer";
        }
    }


    @GetMapping("/debt/jail/sorry/bummer")
    public String jail() {
        return "jail.jsp";
    }

    @PostMapping("/reset")
    public String reset(HttpSession session) {
        session.invalidate();
        return "redirect:/gold";
    }
}

