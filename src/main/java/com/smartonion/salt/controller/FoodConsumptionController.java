package com.smartonion.salt.controller;

import com.smartonion.salt.model.FoodConsumption;
import com.smartonion.salt.service.FoodConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption")
public class FoodConsumptionController {

    @Autowired
    private FoodConsumptionService foodConsumptionService;

    // Get all food consumption records
    @GetMapping
    public ResponseEntity<List<FoodConsumption>> getAllConsumptions() {
        List<FoodConsumption> consumptions = foodConsumptionService.getAllConsumptions();
        return ResponseEntity.ok(consumptions);
    }

    // Get food consumption records by family ID
    @GetMapping("/family/{familyId}")
    public ResponseEntity<List<FoodConsumption>> getConsumptionsByFamilyId(@PathVariable String familyId) {
        List<FoodConsumption> consumptions = foodConsumptionService.getConsumptionsByFamilyId(familyId);
        return ResponseEntity.ok(consumptions);
    }

    // Get food consumption records by profile ID
    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<FoodConsumption>> getConsumptionsByProfileId(@PathVariable String profileId) {
        List<FoodConsumption> consumptions = foodConsumptionService.getConsumptionsByProfileId(profileId);
        return ResponseEntity.ok(consumptions);
    }

    // Add a new food consumption record
    @PostMapping
    public ResponseEntity<FoodConsumption> addConsumption(@RequestBody FoodConsumption foodConsumption) {
        FoodConsumption newConsumption = foodConsumptionService.addConsumption(foodConsumption);
        return ResponseEntity.status(HttpStatus.CREATED).body(newConsumption);
    }
}
