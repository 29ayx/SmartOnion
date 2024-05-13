package com.smartonion.salt.controller;

import com.smartonion.salt.model.Profile;
import com.smartonion.salt.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    @GetMapping("/owner/{userEmail}")
    public ResponseEntity<List<Profile>> getProfilesByUserEmail(@PathVariable String userEmail) {
        List<Profile> profiles = profileService.getProfilesByUserEmail(userEmail);
        if (profiles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
        return ResponseEntity.ok(profiles);
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile savedProfile = profileService.createProfile(profile);
        return ResponseEntity.ok(savedProfile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable String id) {
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable String id, @RequestBody Profile profile) {
        Profile updatedProfile = profileService.updateProfile(id, profile);
        return ResponseEntity.ok(updatedProfile);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable String id) {
        if (profileService.deleteProfile(id)) {
            return ResponseEntity.ok("Profile deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profile not found");
        }
    }

    @GetMapping("/search/byName")
    public ResponseEntity<List<Profile>> getProfilesByName(@RequestParam String name) {
        List<Profile> profiles = profileService.getProfilesByName(name);
        return ResponseEntity.ok(profiles);
    }

//    @GetMapping("/filter/byAllergy")
//    public ResponseEntity<List<Profile>> getProfilesByAllergyType(@RequestParam String allergyType) {
//        List<Profile> profiles = profileService.getProfilesByAllergyType(allergyType);
//        return ResponseEntity.ok(profiles);
//    }
}
