package com.example.quizback.Exception;

public class UserAlreadyExist extends RuntimeException{
    public UserAlreadyExist(String msg){
        System.out.println("User alreay present with username : "+msg);
    }
}
