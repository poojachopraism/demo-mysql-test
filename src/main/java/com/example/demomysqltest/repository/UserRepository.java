package com.example.demomysqltest.repository;

import com.example.demomysqltest.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {


}
