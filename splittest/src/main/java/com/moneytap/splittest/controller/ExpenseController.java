package com.moneytap.splittest.controller;

import com.moneytap.splittest.Repository.CategoryRepository;
import com.moneytap.splittest.Repository.ExpenseRepository;
import com.moneytap.splittest.Repository.Repo;
import com.moneytap.splittest.exception.RecordNotFoundException;
import com.moneytap.splittest.model.Category;
import com.moneytap.splittest.model.Expense;
import com.moneytap.splittest.model.Usr;
import com.moneytap.splittest.service.CategoryService;
import com.moneytap.splittest.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Repo user;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, "createdDate", new CustomDateEditor(format, false));
    }

    @RequestMapping(value = "/category/expense/{id}")
    public String expense(@PathVariable("id") int id, Model model) throws RecordNotFoundException {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        Iterable<Expense> iter=expenseRepository.findAll();
        List<Expense> list = new ArrayList<Expense>();
        for (Expense item : iter) {
            list.add(item);
        }
        model.addAttribute("expenses", list);
        return "expense";
    }

    @RequestMapping(value = "/expense/add")
    public String addExpense(Model model) {
        {
            model.addAttribute("expenses", new Expense());
            return "createExpenses";
        }
    }

    @RequestMapping(path = "/expenses/update/{id}")
    public String editExpensesById(Model model, @PathVariable("id") int id)
            throws RecordNotFoundException {
        if (id != 0) {
            Expense entity = expenseService.getExpenseById(id);
            model.addAttribute("expenses", entity);
        }
        return "updateExpenses";
    }
    @RequestMapping(path = "/category/tag/{id}")
    public String tagFriend(Model model, @PathVariable("id") int id)
    {   //Usr usr=user.findByEmail(email);                  //from user repository
        model.addAttribute("user", new Usr());
        return "addFriend";
    }

    @RequestMapping(path = "/createExpense", method = RequestMethod.POST)
    public String createExpense(Expense expenses)
    {   expenses.setExpenseName(expenses.getExpenseName());
        expenses.setAmount(expenses.getAmount());
        expenses.setCreatedDate(expenses.getCreatedDate());
        expenses = expenseRepository.save(expenses);
        return "redirect:/category/expense/{id}";
    }
    @RequestMapping(path = "/tagFriend", method = RequestMethod.POST)
    public String addUser(Usr usr)
    {   String email=usr.getEmail();
        usr=user.findByEmail(email);
        usr=user.save(usr);
        return "redirect:/category/expense/{id}";
    }
    @RequestMapping(path = "/updateExpenses", method = RequestMethod.POST)
    public String addUser(@RequestParam(value="amount",required = false) Float amount,Expense expense)
    {
        expenseService.updateAmount(amount,expense);
        return "redirect:/category/expense/{id}";
    }
}

