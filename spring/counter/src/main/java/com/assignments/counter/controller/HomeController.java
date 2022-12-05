package com.assignments.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("your_server")
public class HomeController {
    
    @GetMapping("")
    public String index(HttpSession session) {
        if(session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        int pageCount = (int) session.getAttribute("count");
        pageCount++;
        session.setAttribute("count", pageCount);
        return "index.jsp";
    }

    @GetMapping("/counter")
    public String counter() {
        return "countPage.jsp";
    }

    @PostMapping("/counter/increaseby2")
    public String increaseBy2(HttpSession session) {
        int pageCount = (int) session.getAttribute("count");
        pageCount += 1;
        session.setAttribute("count", pageCount);
        return "redirect:/your_server/counter";
    }

    @PostMapping("/counter/increaseby4000")
    public String increaseBy4000(HttpSession session) {
        int pageCount = (int) session.getAttribute("count");
        pageCount += 3999;
        session.setAttribute("count", pageCount);
        return "redirect:/your_server/counter";
    }

    @PostMapping("/counter/reset")
    public String reset(HttpSession session) {
        session.setAttribute("count", 0);
        return "redirect:/your_server/counter";
    }



}
