package com.smartonion.salt.repository.ProfileRepo;


import com.smartonion.salt.model.Profile.Allergies;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AllergiesRepo extends MongoRepository<Allergies, String> {
}

