package com.spring_app.first_spring_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring_app.first_spring_app.model.Users;
import com.spring_app.first_spring_app.repository.UsersRepo;
import com.spring_app.first_spring_app.model.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Users user = usersRepo.findByName(name);

        if (user == null) {
            System.out.println("User not found...");
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);

    }

}
