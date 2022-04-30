package com.example.quizback.service.userService.impl;

import com.example.quizback.model.userDto.User;
import com.example.quizback.repo.userRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Primary
public class userDetailsSecurityImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userRepo.findByUsername(username);
        if ( byUsername != null)
            return byUsername;
        else throw new UsernameNotFoundException("User did not exist");

    }
}


