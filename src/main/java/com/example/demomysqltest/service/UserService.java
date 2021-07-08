package com.example.demomysqltest.service;

import com.example.demomysqltest.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

     String saveUsers(List<User> users);

     String saveSingleUser(User user);

     List<User> getUsers();

     Optional<User> getUserByID(int id);

     String deleteUserByID(int id);

     ResponseEntity<User> updateUser(User user, int id);
}
