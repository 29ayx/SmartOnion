package com.smartonion.salt.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
    
}
