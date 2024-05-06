package com.smartonion.salt.service;

import com.smartonion.salt.model.Item;
import com.smartonion.salt.model.Profile;
import com.smartonion.salt.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;



    public Profile createProfile(Profile profile) {
        profile.setProfileId(UUID.randomUUID().toString().split("-")[0]);
        return profileRepository.save(profile);
    }


    public Profile getProfileById(String id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElse(null);  // Returns null if the profile is not found
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile updateProfile(String id, Profile updatedProfile) {
        Profile profile = getProfileById(id);
        profile.setName(updatedProfile.getName());
//        profile.setFoodPreference(updatedProfile.getFoodPreference());
//        profile.setAllergies(updatedProfile.getAllergies());
        return profileRepository.save(profile);
    }
//
//    public void deleteProfile(String id) {
//        profileRepository.deleteById(id);
//    }

    public boolean deleteProfile(String profileId) {
        // Check if the profile exists before attempting to delete
        if (profileRepository.existsById(profileId)) {
            profileRepository.deleteById(profileId);
            return true; // Return true if the profile was successfully deleted
        } else {
            return false; // Return false if no profile was found with the given ID
        }
    }

    public List<Profile> getProfilesByName(String name) {
        return profileRepository.findByName(name);
    }

    public List<Profile> getProfilesByUserEmail(String userEmail) {
        return profileRepository.findByUserEmail(userEmail);
    }

//    public List<Profile> getProfilesByAllergyType(String allergyType) {
//        return profileRepository.findByAllergies_AllergyType(allergyType);
//    }
}
