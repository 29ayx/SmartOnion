package com.smartonion.salt.service;


import com.smartonion.salt.model.FamilyInventory;
import com.smartonion.salt.repository.FamilyInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyInventroyService  {

    @Autowired
    private FamilyInventoryRepository familyInventoryRepository;

    public FamilyInventory addItemToFamily(String familyId, String itemId, float quantity, Date expiryDate, boolean inStock) {
        // Optional: Validate the item exists in the items catalog

        // Check if the item is already in the family's inventory
        List<FamilyInventory> existingItems = familyInventoryRepository.findByFamilyId(familyId)
                .stream()
                .filter(item -> item.getItemId().equals(itemId))
                .collect(Collectors.toList());

        if (!existingItems.isEmpty()) {
            FamilyInventory existingItem = existingItems.get(0);
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            return familyInventoryRepository.save(existingItem);
        } else {
            FamilyInventory newItem = new FamilyInventory();
            newItem.setFamilyId(familyId);
            newItem.setItemId(itemId);
            newItem.setQuantity(quantity);
            newItem.setExpiryDate(expiryDate);
            newItem.setInStock(inStock);
            return familyInventoryRepository.save(newItem);
        }
    }
}
