package com.moneytap.ankit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }
}