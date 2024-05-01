package com.smartonion.salt.repository;

import com.smartonion.salt.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProfileRepository extends MongoRepository<Profile, String> {
    List<Profile> findByName(String name);

    List<Profile> findByAllergies_AllergyType(String allergyType);
}
