package com.smartonion.salt.service;


import com.smartonion.salt.model.FamilyInventory;
import com.smartonion.salt.repository.FamilyInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyInventoryService {

    @Autowired
    private FamilyInventoryRepository familyInventoryRepository;

    public FamilyInventory addItemToFamily(String familyId, String itemId, float quantity, boolean inStock) {
        // First, check if the item already exists in the family's inventory
        List<FamilyInventory> existingItems = familyInventoryRepository.findByFamilyId(familyId);
        FamilyInventory existingItem = existingItems.stream()
                .filter(item -> itemId.equals(item.getItemId()))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            // If the item exists, update quantity or other fields
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            existingItem.setInStock(inStock);
//            existingItem.setExpiryDate(expiryDate);
            return familyInventoryRepository.save(existingItem);
        } else {
            // If not, create a new inventory item
            FamilyInventory newItem = new FamilyInventory();
            newItem.setFamilyId(familyId);
            newItem.setItemId(itemId);  // Ensure itemId is set here
            newItem.setQuantity(quantity);
//            newItem.setExpiryDate(expiryDate);
            newItem.setInStock(inStock);
            return familyInventoryRepository.save(newItem);
        }
    }

}
