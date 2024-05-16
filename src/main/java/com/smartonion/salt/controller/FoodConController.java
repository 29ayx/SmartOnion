package com.smartonion.salt.controller;


import com.smartonion.salt.model.FoodConsumption;
import com.smartonion.salt.service.FoodConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/record")
public class FoodConController {

    @GetMapping("/{email}")
    public ResponseEntity<?> findAllFoodConsumptionByFamilyId(@PathVariable String email){
        try {
            List<FoodConsumption> report = service.findAllFoodConsumptionByFamilyId(email);
            //Checks the user exist and adds
            return ResponseEntity.ok(report);
            //Else throws and error
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error finding food consumption: " + ex.getMessage());
        }
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<?> getAllFoodConsumptionByProfileId(@PathVariable String profileId){
        try {
            List<FoodConsumption> report = service.findAllFoodConsumptionByPofileId(profileId);
            //Checks the user exist and adds
            return ResponseEntity.ok(report);
            //Else throws and error
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error finding food consumption: " + ex.getMessage());
        }
    }

    @Autowired
    FoodConService service;


    @PostMapping("/{email}/{profileId}")
    public ResponseEntity<?> addFoodConsumption(@PathVariable  String email, @PathVariable String profileId, @RequestBody FoodConsumption foodConsumption){
            service.addFoodConsumption(email, profileId, foodConsumption);
            return ResponseEntity.ok(service.addFoodConsumption(email, profileId, foodConsumption));
    }




}
