package com.smartonion.salt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import com.smartonion.salt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User addUser(User user) {
        repository.save(user);
        return repository.save(user);
    }
    

    public List<User> findAllUsers(){
        return repository.findAll();
    }

    

}
