package com.moneytap.splittest.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "expense_id")
    private int expenseId;

    @Column(name = "expense_name")
    @NotNull(message="Expense name cannot be empty")
    private String expenseName;

    @Column(name = "amount")
    @Min(1)
    private double amount;

    @Column(name = "created_date")
    @Past(message="Date cannot be in the future")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Usr user;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Expense() {
        // TODO Auto-generated constructor stub
    }


    public Expense(int expenseId, String expenseName, double amount, Date createdDate) {
        super();
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.amount = amount;
        this.createdDate = createdDate;

    }


    public int getExpenseId() {
        return expenseId;
    }


    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }


    public String getExpenseName() {
        return expenseName;
    }


    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public Date getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


}
