package com.assignments.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.savetravels.models.Expense;
import com.assignments.savetravels.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("")
    public String index(@ModelAttribute("expense") Expense expense, Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "index.jsp";
    }

    @GetMapping("/search")
    public String searchExpenses(
        @ModelAttribute("expense") Expense expense,
        @RequestParam("searchTerm") String search, Model model) {
        model.addAttribute("expenses", expenseService.searchExpenses(search));
        return "index.jsp";
    }

    @PostMapping("/new")
    public String newExpense( Model model,
        @Valid
        @ModelAttribute("expense") Expense expense,
        BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("expenses", expenseService.getAllExpenses());
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
    }

    @GetMapping("/{id}")
    public String expenseDetails(
        Model model, 
        @PathVariable("id") Long id) {
        model.addAttribute("expense", expenseService.getOneExpense(id));
        return "expenseDetails.jsp";
    }

    @GetMapping("/edit/{id}")
    public String editExpense(
        Model model, 
        @PathVariable("id") Long id) {
        Expense expenseToBeEdited = expenseService.getOneExpense(id);
        if (expenseToBeEdited != null) {
            model.addAttribute("expense", expenseToBeEdited);
            return "editExpense.jsp";
        } else {
            return "redirect:/expenses";
        }
    }

    

    @PutMapping("/edit/{id}")
    public String updateExpense(
        @PathVariable("id") Long id,
        @Valid
        @ModelAttribute("expense") Expense expense,
        BindingResult result) {
        if (result.hasErrors()) {
            return "editExpense.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

}