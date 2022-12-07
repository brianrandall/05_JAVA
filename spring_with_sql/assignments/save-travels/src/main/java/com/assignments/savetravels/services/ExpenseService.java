package com.assignments.savetravels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignments.savetravels.models.Expense;
import com.assignments.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    //create an expense
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    //get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> searchExpenses(String search) {
        return expenseRepository.findExpenseByExpenseNameContaining(search);
    }

    //get one expense 
    public Expense getOneExpense(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    //update an expense
    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    //delete an expense
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

}
