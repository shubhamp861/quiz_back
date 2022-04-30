package com.example.quizback.service.userService.impl;

import com.example.quizback.Exception.UserAlreadyExist;
import com.example.quizback.model.userDto.Roles;
import com.example.quizback.model.userDto.User;
import com.example.quizback.repo.userRepo.UserRepo;
import com.example.quizback.service.userService.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class userServiceImpl implements userService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user, ArrayList<Roles> userRoles) {
        //System.out.println(new Gson().toJson(user));
        if(!(userRepo.findByUsername(user.getUsername())!=null)){
            user.getRolesSet().addAll(userRoles);

            return  userRepo.save(user);
        }
        else throw new UserAlreadyExist(user.getUsername());
    }

    @Override
    public User getUserById(Long id) {
       return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUserById(User user) {
        userRepo.delete(user);
    }

    @Override
    public User getUserByUserName(String user) {
        return userRepo.findByUsername(user);
    }

    @Override
    public void deleteAll() {
        userRepo.deleteAll();
    }
}
