package com.smartonion.salt.service.InventoryService;

import com.smartonion.salt.model.Inventory.Vegetable;
import com.smartonion.salt.repository.InventoryRepo.VegetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepo vegetableRepo;

    // CRUD Methods

    public Vegetable createVegetable(Vegetable vegetable) {
        return vegetableRepo.save(vegetable);
    }

    public List<Vegetable> getAllVegetables() {
        return vegetableRepo.findAll();
    }

    public Optional<Vegetable> getVegetableById(String vegetableId) {
        return vegetableRepo.findById(vegetableId);
    }

    public Vegetable updateVegetable(Vegetable vegetable) {
        return vegetableRepo.save(vegetable);
    }
}