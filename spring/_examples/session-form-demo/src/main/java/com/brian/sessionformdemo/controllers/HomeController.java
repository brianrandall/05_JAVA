package com.brian.sessionformdemo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String setCount(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        int pageCount = (int)session.getAttribute("count");
        pageCount++;
        session.setAttribute("count", pageCount);
        return "counterPage.jsp";
    }

    @GetMapping("/get/count")
    public String getCount() {
        return "countGet.jsp";
    }
    
    @GetMapping("/search")
    public String searchForm() {
        return "searchForm.jsp";
    }

    @GetMapping("/search/results")
    public String searchResults(@RequestParam("searchTerm") String searchTerm, Model model) {
        model.addAttribute("searchTerm", searchTerm);
        return "displaySearchResults.jsp";
    }

    @GetMapping("/review/form")
    public String renderReviewForm() {
        return "/postMethodForm/reviewForm.jsp";
    }

    @PostMapping("/form/process")
    public String processForm (
        @RequestParam("movie") String movie,
        @RequestParam("comment") String comment,
        @RequestParam("rating") int rating,
        @RequestParam("uuid") String uuid,
        HttpSession session, RedirectAttributes redirectAttributes ) {
            boolean isValid = true;
            if (rating < 1 || rating > 5) {
                isValid = false;
                redirectAttributes.addFlashAttribute("ratingError", "Rating must be between 1 and 5");
            }
            if (movie.length() < 2) {
                isValid = false;
                redirectAttributes.addFlashAttribute("movieError", "Movie title must be at least 1 character");
            }
            if (comment.length() < 2) {
                isValid = false;
                redirectAttributes.addFlashAttribute("commentError", "Comment must be at least 1 character");
            }
            if (isValid == false) {
                return "redirect:/review/form";
            }
            session.setAttribute("movieFromSession", movie);
            session.setAttribute("commentFromSession", comment);
            session.setAttribute("ratingFromSession", rating);
            session.setAttribute("uuidFromSession", uuid);
            return "redirect:/review/results";
    }

    @GetMapping("/review/results")
    public String viewFormResults () {
        return "/postMethodForm/displayReviewForm.jsp";
    }

}
