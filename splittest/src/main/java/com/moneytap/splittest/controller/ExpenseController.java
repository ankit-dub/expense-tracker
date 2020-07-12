/*package com.moneytap.splittest.controller;

import com.moneytap.splittest.Repository.CategoryRepository;
import com.moneytap.splittest.Repository.ExpenseRepository;
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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, "createdDate", new CustomDateEditor(format, false));
    }

    @RequestMapping(value = "/{id}/expense")
    public String expense(@PathVariable("id") int id, Model model) throws RecordNotFoundException {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);

        //model.addAttribute("expenses", expenses);
        return "listexpenses";
    }

    @RequestMapping(value = "/expense/add", method = RequestMethod.POST)
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
        } else {
            model.addAttribute("expenses", new Category());
        }
        return "updateExpenses";
    }
    @RequestMapping(path = "/category/tag/{id}")
    public String deleteCategoryById(Model model, @PathVariable("id") int id)
    { categoryRepository.deleteById(id);
        return "addFriend";
    }

    @RequestMapping(path = "/category/createExpenses", method = RequestMethod.POST)
    public String createExpense(Expense expenses)
    {
        expenseService.createnewExpense(expenses);
        return "redirect:/category";
    }
}

*/