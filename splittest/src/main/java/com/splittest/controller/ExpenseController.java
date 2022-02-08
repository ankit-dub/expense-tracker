package splittest.src.main.java.com.splittest.controller;

import splittest.src.main.java.com.splittest.Repository.CategoryRepository;
import splittest.src.main.java.com.splittest.Repository.ExpenseRepository;
import splittest.src.main.java.com.splittest.Repository.Repo;
import splittest.src.main.java.com.splittest.exception.RecordNotFoundException;
import splittest.src.main.java.com.splittest.model.Category;
import splittest.src.main.java.com.splittest.model.Expense;
import splittest.src.main.java.com.splittest.model.Usr;
import splittest.src.main.java.com.splittest.service.CategoryService;
import splittest.src.main.java.com.splittest.service.ExpenseService;
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
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
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
    public String createExpense(@Valid Expense expenses)
    {   expenses.setExpenseName(expenses.getExpenseName());
        expenses.setAmount(expenses.getAmount());
        expenses.setCreatedDate(expenses.getCreatedDate());
        //expenses.setUser(user.findByEmail(usr.getEmail()));
        //expenses.setCategory(categoryRepository.findById(category.getCategoryId()));
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
    public String addUser(@RequestParam(value="amount",required = false) Double amount,Expense expense)
    {
        expenseService.updateAmount(amount,expense);
        return "redirect:/category/expense/{id}";
    }
}

