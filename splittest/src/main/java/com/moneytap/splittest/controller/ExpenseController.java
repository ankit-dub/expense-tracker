package com.moneytap.splittest.controller;

/*import com.moneytap.splittest.model.Expense;
import com.moneytap.splittest.model.Usr;
import com.moneytap.splittest.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;*/
import org.springframework.stereotype.Controller;
/*import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;*/

@Controller
public class ExpenseController {
 /*   @Autowired
    private ExpenseService expenseService;

   @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, "createdDate", new CustomDateEditor(format, false));
    }

    @RequestMapping(value = "/expense")
    public ModelAndView expense(){
        ModelAndView page=new ModelAndView();
        Expense expense= new Expense();
        List<String> expenseServ = expenseService.getOnlyExpensename();
        page.addObject("expenseNames", expenseServ);
        page.setViewName("expense");
        return page;
    }
    @RequestMapping(value = "/expense",method = RequestMethod.POST)
    public ModelAndView expenseUser(@Valid Expense expense, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView page=new ModelAndView();
        if(bindingResult.hasErrors()){
            page.addObject("successMessage", "Fill it again some error");
            modelMap.addAttribute("bindingResult",bindingResult);     //to show on page
        }
        else{
            expenseService.addexpense(expense);
            page.addObject("successMessage", "Expenses at your fingertip!!");
        }

        page.addObject("expense", expense);
        page.setViewName("expense");
        return page;
    }*/
}
