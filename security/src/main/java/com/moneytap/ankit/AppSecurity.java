package com.moneytap.ankit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        
        List<UserDetails> Users= new ArrayList<>();
        Users.add(User.withDefaultPasswordEncoder().username("Ankit").password("1234").roles("admin").build());
        Users.add(User.withDefaultPasswordEncoder().username("Sajal").password("4546").roles("electrical").build());
        Users.add(User.withDefaultPasswordEncoder().username("Sandesh").password("7897").roles("IT").build());
        Users.add(User.withDefaultPasswordEncoder().username("Baba").password("1234").roles("IT").build());
        //kill -9 $(lsof -t -i:8080)

        
        return new InMemoryUserDetailsManager(Users);
    }
    
}