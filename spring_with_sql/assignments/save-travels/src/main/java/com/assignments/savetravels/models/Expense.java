package com.assignments.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Expense name is required")
    @Size(min = 2, max = 255, message = "Expense name must be between 2 and 255 characters")
    private String expenseName;

    @NotNull(message = "Vendor name is required")
    @Size(min = 2, max = 255, message = "Vendor name must be between 2 and 255 characters")
    private String vendorName;

    @NotNull(message = "Expense amount is required")
    @Min(value = 1, message = "Expense amount must be greater than or equal to 0")
    private Double expenseAmount;

    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    public Expense() {
    }

    public Expense(String expenseName, String vendorName, Double expenseAmount, String description) {
        this.expenseName = expenseName;
        this.vendorName = vendorName;
        this.expenseAmount = expenseAmount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}