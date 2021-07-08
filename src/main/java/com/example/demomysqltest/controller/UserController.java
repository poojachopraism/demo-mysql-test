package com.example.demomysqltest.controller;

import com.example.demomysqltest.model.User;
import com.example.demomysqltest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/addUsers")
    @ResponseBody  String saveUsers(@RequestBody List<User> users){

        return userService.saveUsers(users);
    }

    @PostMapping("/addUser")
    @ResponseBody String saveSingleUser(@RequestBody User user){

        return userService.saveSingleUser(user);
    }

    @GetMapping("/getAllUsers")
    @ResponseBody List<User> getAllUsers(){

        return userService.getUsers();
    }

    @GetMapping("/user/{Id}")
    @ResponseBody Optional<User> getUserByID(@PathVariable int Id){

       return userService.getUserByID(Id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody String deleteUser(@PathVariable int id){
        return userService.deleteUserByID(id);
    }

    @PutMapping("/updateUser/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable int id){
        return userService.updateUser(user, id);
    }
}
