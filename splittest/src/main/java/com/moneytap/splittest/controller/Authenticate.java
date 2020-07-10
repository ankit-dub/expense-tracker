package com.moneytap.splittest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Authenticate {
    @RequestMapping(value ={"/login"})
    public ModelAndView login(){
        ModelAndView page=new ModelAndView();
        page.setViewName("login");
        return page;
    }
    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView page=new ModelAndView();
        page.setViewName("register");
        return page;
    }
    @RequestMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView page = new ModelAndView();
        page.setViewName("home");
        return page;
    }
}

