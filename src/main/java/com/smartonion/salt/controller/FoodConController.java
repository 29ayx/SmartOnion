package com.smartonion.salt.controller;


import com.smartonion.salt.model.AdminUser;
import com.smartonion.salt.model.FoodConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/record")
public class FoodConService {

    @Autowired
    com.smartonion.salt.service.FoodConService service;

    @GetMapping("/{email}")
    public ResponseEntity<?> getAllFoodConsumptionByEmail(@PathVariable String email){
        try {
            List<FoodConsumption> report = service.findAllFoodConsumptionByFamilyId(email);
            //Checks the user exist and adds
            return ResponseEntity.ok(report);
            //Else throws and error
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error finding food consumption: " + ex.getMessage());
        }
    }


    @PostMapping("/{email}/{profileId}")
    public ResponseEntity<?> addFoodConsumption(@PathVariable  String email, @PathVariable String profileId, @RequestBody FoodConsumption foodConsumption){
            service.addFoodConsumption(email, profileId, foodConsumption);
            return ResponseEntity.ok("Food consumption added successfully");
    }




}
