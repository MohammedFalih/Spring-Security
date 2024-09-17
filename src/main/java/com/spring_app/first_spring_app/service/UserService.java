package com.spring_app.first_spring_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring_app.first_spring_app.model.Users;
import com.spring_app.first_spring_app.repository.UsersRepo;

@Service
public class UserService {

    @Autowired
    UsersRepo usersRepo;
    
    private BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder(12);
    
    public Users register(Users user) {

        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }
}
