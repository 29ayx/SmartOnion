package com.smartonion.salt.service.ProfileService;

import com.smartonion.salt.model.Profile.Profile;
import com.smartonion.salt.repository.ProfileRepo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    // CRUD Methods

    public Profile createProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    public Optional<Profile> getProfileById(String profileId) {
        return profileRepo.findById(profileId);
    }

    public Profile updateProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    public void deleteProfile(String profileId) {
        profileRepo.deleteById(profileId);
    }
}
