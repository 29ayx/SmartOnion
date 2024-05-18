package com.smartonion.salt.repository;

import com.smartonion.salt.model.AdminUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminUserRepository extends MongoRepository<AdminUser, String>{

//    AdminUser findByEmail(String email);
    Optional<AdminUser> findByEmail(String email);


    void deleteByEmail(String id);
}
