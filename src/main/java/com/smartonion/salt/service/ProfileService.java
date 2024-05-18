package com.smartonion.salt.service;

import com.smartonion.salt.model.AdminUser;
import com.smartonion.salt.model.FoodConsumption;
import com.smartonion.salt.model.Item;
import com.smartonion.salt.model.Profile;
import com.smartonion.salt.model.inventory.UserInventory;
import com.smartonion.salt.repository.AdminUserRepository;
import com.smartonion.salt.repository.FoodConsumptionRepository;
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


    @Autowired
    private FoodConsumptionRepository foodConsumptionRepository;



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
        profile.setDob(updatedProfile.getDob());
        profile.setDietgoal(updatedProfile.getDietgoal());
        profile.setAllergies(updatedProfile.getAllergies());
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


@Autowired
    AdminUserRepository adminUserRepository;

    // Consume an item by profile ID and log the consumption
    public Optional<UserInventory> consumeItemByProfileId(String profileId, String itemId, float quantity) {
        Optional<Profile> profile = profileRepository.findById(profileId);
        if (profile.isPresent()) {
            Profile existingProfile = profile.get();
            String  userEmail = existingProfile.getUserEmail();
            Optional<AdminUser> adminUser = adminUserRepository.findByEmail(userEmail);
            if (adminUser.isPresent()) {
                List<UserInventory> items = adminUser.get().getInventoryItems();
                Optional<UserInventory> inventoryItem = items.stream()
                        .filter(item -> itemId.equals(item.getItemId()))
                        .findFirst();

                if (inventoryItem.isPresent()) {
                    UserInventory item = inventoryItem.get();
                    float newQuantity = Float.parseFloat(item.getQuantity()) - quantity;
                    if (newQuantity < 0) {
                        return Optional.empty();
                    }
                    item.setQuantity(String.valueOf(newQuantity));

                    // Log the consumption
                    FoodConsumption foodConsumption = new FoodConsumption(
                            adminUser.get().getId(),
                            profileId,
                            item.getName(),
                            quantity,
                            Float.parseFloat(item.getCalories()) * quantity
                    );
                    foodConsumptionRepository.save(foodConsumption);

                    adminUserRepository.save(adminUser.get());
                    return Optional.of(item);
                }
            }
        }
        return Optional.empty();
    }

}



