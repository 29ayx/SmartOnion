package com.smartonion.salt.repository.ProfileRepo;

import com.smartonion.salt.model.Profile.Profile; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepo extends MongoRepository<Profile, String> {
}
