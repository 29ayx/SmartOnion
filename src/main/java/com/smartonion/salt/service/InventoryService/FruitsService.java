package com.smartonion.salt.service.InventoryService;

import com.smartonion.salt.model.Inventory.Fruits;
import com.smartonion.salt.repository.InventoryRepo.FruitsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitsService {

    @Autowired
    private FruitsRepo fruitsRepo;

    // CRUD Methods

    public Fruits createFruit(Fruits fruit) {
        return fruitsRepo.save(fruit);
    }

    public List<Fruits> getAllFruits() {
        return fruitsRepo.findAll();
    }

    public Optional<Fruits> getFruitById(String fruitId) {
        return fruitsRepo.findById(fruitId);
    }

    public Fruits updateFruit(Fruits fruit) {
        return fruitsRepo.save(fruit);
    }

    public void deleteFruit(String fruitId) {
        fruitsRepo.deleteById(fruitId);
    }
}
