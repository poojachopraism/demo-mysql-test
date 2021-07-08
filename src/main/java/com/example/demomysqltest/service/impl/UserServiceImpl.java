package com.example.demomysqltest.service.impl;

import com.example.demomysqltest.model.User;
import com.example.demomysqltest.repository.UserRepository;
import com.example.demomysqltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String saveUsers(List<User> users) {
       userRepository.saveAll(users);
        return " Saved Users " +  users.size();
    }

    @Override
    public String saveSingleUser(User user) {
          userRepository.save(user);
          return "Saved : " + user;
    }

    @Override
    public List<User> getUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByID(int id) {


        return userRepository.findById(id);
    }

}
