package com.moneytap.splittest.controller;

import com.moneytap.splittest.Repository.Repo;
import com.moneytap.splittest.model.Category;
import com.moneytap.splittest.model.Usr;
import com.moneytap.splittest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@Controller
public class Authenticate {
    @Autowired
    UserService userService;

    @Autowired
    Repo userRepo;

    @RequestMapping(value ={"/"})
    public ModelAndView dfault(){
        ModelAndView page=new ModelAndView();
        page.setViewName("default");
        return page;
    }
    @RequestMapping(value ={"/login"})
    public ModelAndView login(){
        ModelAndView page=new ModelAndView();
        page.setViewName("login");
        return page;
    }
    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView page=new ModelAndView();
        Usr user=new Usr();
        page.addObject("user", user);
        page.setViewName("register");
        return page;
    }
    @RequestMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView page = new ModelAndView();
        page.setViewName("home");
        return page;
    }
    @RequestMapping(value = "/admin")
    public String adminhome(Model model) {
        List<Usr> list = userRepo.findAll();
        model.addAttribute("users", list);
        return "admin";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView registrationUser(@Valid Usr user,BindingResult bindingResult,ModelMap modelMap){
            ModelAndView page=new ModelAndView();
            if(bindingResult.hasErrors()){
                page.addObject("successMessage", "Fill it again some error");
                modelMap.addAttribute("bindingResult",bindingResult);     //to show on page 
            }
            else if(userService.isPresent(user)){
                    page.addObject("successMessage", "Account already exists");

            }
            else{
                userService.saveUser(user);
                page.addObject("successMessage", "Registered completed!!!!");
            }
        page.addObject("user",new Usr());
        page.setViewName("register");
        return page;
    }

}

