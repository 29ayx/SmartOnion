package com.smartonion.salt.service;

import com.smartonion.salt.model.AdminUser;
import com.smartonion.salt.model.FoodConsumption;
import com.smartonion.salt.model.inventory.UserInventory;
import com.smartonion.salt.repository.AdminUserRepository;
import com.smartonion.salt.repository.FoodConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private AdminUserRepository adminUserRepository;


    @Autowired
    private FoodConsumptionRepository foodConsumptionRepository;


    // Get all items for a user by email
    public List<UserInventory> getAllInventoryItems(String email) {
        Optional<AdminUser> user = adminUserRepository.findByEmail(email);
        return user.map(AdminUser::getInventoryItems).orElse(null);
    }

    // Get item by ID and user email
    public Optional<UserInventory> getInventoryItemById(String email, String itemId) {
        Optional<AdminUser> user = adminUserRepository.findByEmail(email);
        if (user.isPresent()) {
            return Optional.ofNullable(user.get().getInventoryItemsById(itemId));
        }
        return Optional.empty();
    }

    // Add or update inventory item by user email
    public Optional<AdminUser> addOrUpdateInventoryItem(String email, UserInventory item) {
        Optional<AdminUser> user = adminUserRepository.findByEmail(email);
        if (user.isPresent()) {
            AdminUser existingUser = user.get();
            List<UserInventory> items = existingUser.getInventoryItems();
            items.removeIf(existingItem -> item.getItemId().equals(existingItem.getItemId()));
            items.add(item);
            adminUserRepository.save(existingUser);
            return Optional.of(existingUser);
        }
        return Optional.empty();
    }

    // Delete inventory item by ID and user email
    public boolean deleteInventoryItemById(String email, String itemId) {
        Optional<AdminUser> user = adminUserRepository.findByEmail(email);
        if (user.isPresent()) {
            AdminUser existingUser = user.get();
            List<UserInventory> items = existingUser.getInventoryItems();
            boolean removed = items.removeIf(item -> itemId.equals(item.getItemId()));
            if (removed) {
                adminUserRepository.save(existingUser);
            }
            return removed;
        }
        return false;
    }

    // Consume an item and log the consumption
    public Optional<UserInventory> consumeItem(String email, String itemId, float quantity) {
        Optional<AdminUser> user = adminUserRepository.findByEmail(email);
        if (user.isPresent()) {
            AdminUser existingUser = user.get();
            List<UserInventory> items = existingUser.getInventoryItems();
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
                        existingUser.getId(),
                        email,
                        item.getName(),
                        quantity,
                        Float.parseFloat(item.getCalories()) * quantity
                );
                foodConsumptionRepository.save(foodConsumption);

                adminUserRepository.save(existingUser);
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }


    // Consume an item by profile ID and log the consumption
    public Optional<UserInventory> consumeItemByProfileId(String profileId, String itemId, float quantity) {
        Optional<AdminUser> user = adminUserRepository.findById(profileId);
        if (user.isPresent()) {
            AdminUser existingUser = user.get();
            List<UserInventory> items = existingUser.getInventoryItems();
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
                        existingUser.getId(),
                        profileId,
                        item.getName(),
                        quantity,
                        Float.parseFloat(item.getCalories()) * quantity
                );
                foodConsumptionRepository.save(foodConsumption);

                adminUserRepository.save(existingUser);
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

}
