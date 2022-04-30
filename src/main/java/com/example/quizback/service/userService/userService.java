package com.example.quizback.service.userService;
import com.example.quizback.model.userDto.Roles;
import com.example.quizback.model.userDto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public interface userService {

    User createUser(User user, ArrayList<Roles> userRoles);
    User getUserById(Long id);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUserById(User user);
    User getUserByUserName(String user);
    void deleteAll();
}
