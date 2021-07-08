package com.example.demomysqltest.service.impl;

import com.example.demomysqltest.model.User;
import com.example.demomysqltest.repository.UserRepository;
import com.example.demomysqltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Override
    public String deleteUserByID(int id) {

        userRepository.deleteById(id);
        return "Deleted Id : " +  id;
    }

    @Override
    public ResponseEntity<User> updateUser(User user, int id) {

        if(userRepository.findById(id)!=null){
            user.setEmail(user.getEmail());
            user.setName(user.getName());
        }
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
