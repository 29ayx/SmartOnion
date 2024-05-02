package com.smartonion.salt.service.InventoryService;

import com.smartonion.salt.model.Inventory.Meat;
import com.smartonion.salt.repository.InventoryRepo.MeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeatService {

    @Autowired
    private MeatRepo meatRepo;

    // CRUD Methods

    public Meat createMeat(Meat meat) {
        return meatRepo.save(meat);
    }

    public List<Meat> getAllMeat() {
        return meatRepo.findAll();
    }

    public Optional<Meat> getMeatById(String meatId) {
        return meatRepo.findById(meatId);
    }

    public Meat updateMeat(Meat meat) {
        return meatRepo.save(meat);
    }

    public void deleteMeat(String meatId) {
        meatRepo.deleteById(meatId);
    }
}

