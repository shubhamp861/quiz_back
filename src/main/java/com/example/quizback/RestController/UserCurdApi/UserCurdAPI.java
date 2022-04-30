package com.example.quizback.RestController.UserCurdApi;
import com.example.quizback.model.userDto.Roles;
import com.example.quizback.model.userDto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/v1")
@CrossOrigin("*")
public class UserCurdAPI {

    @Autowired
    com.example.quizback.service.userService.userService userService;
    @GetMapping("/getUserById/{Id}")
    public <T> ResponseEntity<T> getUserById(@PathVariable("Id") Long Id){
        return new ResponseEntity<T>((T) userService.getUserById(Id),HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public <T> ResponseEntity<List<T>> getAllUser(){
        return new ResponseEntity<List<T>>((List<T>) userService.getAllUser(),HttpStatus.OK);
    }

    @PostMapping(value = {"/create"})
    public <T> ResponseEntity<T> createUser(@RequestBody User user){
        Roles roles = new Roles();
        roles.setRoleName("ADMIN");
        ArrayList<Roles> rolesList = new ArrayList<>();
        rolesList.add(roles);
        T user1 = (T) userService.createUser(user, rolesList);
        return new ResponseEntity<T>(user1, HttpStatus.OK);
    }

    @PostMapping(value = {"/update"})
    public <T> ResponseEntity<T> updateUser(@RequestBody User user){
        T user1 = (T) userService.updateUser(user);
        return new ResponseEntity<T>(user1, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public <T> ResponseEntity<T> deleteUser(@RequestBody User user){
        userService.deleteUserById(user);
        return new ResponseEntity<T>((T)"User removed !!",HttpStatus.OK);
    }

    @GetMapping("/getUserByUserName/{userName}")
    public <T> ResponseEntity<T> getUserByUserName(@PathVariable("userName") String userName){
        return new ResponseEntity<T>((T) userService.getUserByUserName(userName),HttpStatus.OK);
    }

    @GetMapping("/deleteAll")
    public String deleteAll(){
        userService.deleteAll();
        return "completed";
    }


}
