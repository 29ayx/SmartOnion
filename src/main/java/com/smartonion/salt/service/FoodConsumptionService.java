package com.smartonion.salt.service;

import com.smartonion.salt.model.AdminUser;
import com.smartonion.salt.model.FoodConsumption;
import com.smartonion.salt.model.Profile;
import com.smartonion.salt.repository.FoodConsumptionRepository;
import com.smartonion.salt.repository.ProfileRepository;
import com.smartonion.salt.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodConService {

    @Autowired
    FoodConsumptionRepository repository;

    @Autowired
    ProfileRepository profile;
    @Autowired
    AdminUserRepository user;

    public List<FoodConsumption> findAllFoodConsumptionByFamilyId(String email) {

        Optional<AdminUser> exisiting_user = user.findByEmail(email);
        if (exisiting_user.isPresent()){
            return repository.findAllByFamilyId();
        }
        else{
            return null;
        }

    }

    public boolean addFoodConsumption(String email, String profileId, FoodConsumption foodConsumption) {
        Optional<AdminUser> exisiting_user = user.findByEmail(email);
        if (exisiting_user.isPresent()){

            foodConsumption.setFamilyId(email);
            foodConsumption.setProfileId(profileId);

            repository.save(foodConsumption);
            return true;
        }
        else{
            return false;
        }
    }

    public List<FoodConsumption> findAllFoodConsumptionByPofileId(String profileId) {
        Optional<Profile> exisiting_profile = profile.findById(profileId);
        if (exisiting_profile.isPresent()){
            return repository.findAllByProfileId(profileId);
        }
        else{
            return null;
        }
    }
}
