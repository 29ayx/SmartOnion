package com.smartonion.salt.service.InventoryService;

import com.smartonion.salt.model.Inventory.FoodItem;
import com.smartonion.salt.repository.InventoryRepo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepo foodItemRepo;

    // CRUD Methods

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepo.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepo.findAll();
    }

    public Optional<FoodItem> getFoodItemById(String foodItemId) {
        return foodItemRepo.findById(foodItemId);
    }

    public FoodItem updateFoodItem(FoodItem foodItem) {
        return foodItemRepo.save(foodItem);
    }

    public void deleteFoodItem(String foodItemId) {
        foodItemRepo.deleteById(foodItemId);
    }
}
