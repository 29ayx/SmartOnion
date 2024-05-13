package com.smartonion.salt.controller;


import com.smartonion.salt.model.FamilyInventory;
import com.smartonion.salt.model.Item;
import com.smartonion.salt.service.FamilyInventoryService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/familyInventory")
public class FamilyInventoryController  {

    @Autowired
    private FamilyInventoryService familyInventoryService;

    @PostMapping("/add")
    public ResponseEntity<FamilyInventory> addItemToFamily(@RequestBody Item addItemRequest) {
        FamilyInventory addedItem = familyInventoryService.addItemToFamily(
                addItemRequest.getFamilyId(),
                addItemRequest.getItemId(),
                addItemRequest.getQuantity(),
//                addItemRequest.getExpiryDate(),
                addItemRequest.isInStock()
        );
        return ResponseEntity.ok(addedItem);
    }
}
