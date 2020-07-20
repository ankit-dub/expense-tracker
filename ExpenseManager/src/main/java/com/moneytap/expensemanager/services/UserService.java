package com.moneytap.expensemanager.services;

import com.moneytap.expensemanager.model.User;
import com.moneytap.expensemanager.exceptions.EtAuthException;
import com.moneytap.expensemanager.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User validateUser(String email, String password) throws EtAuthException {
        User user= userRepository.findByEmail(email);
        try{
        if(!BCrypt.checkpw(password,user.getPassword()))
            throw new EtAuthException("Invalid email/password");
        return user;
        }catch (
    EmptyResultDataAccessException e) {
        throw new EtAuthException("Invalid email/password");
    }
    }

    public User registerUser(User user) throws EtAuthException {
        String hashpassword= BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        user.setPassword(hashpassword);
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
