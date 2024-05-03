package com.smartonion.salt.service.InventoryService;

import com.smartonion.salt.model.Inventory.Drink;
import com.smartonion.salt.repository.InventoryRepo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepo drinkRepo;

    // CRUD Methods

    public Drink createDrink(Drink drink) {
        return drinkRepo.save(drink);
    }

    public List<Drink> getAllDrinks() {
        return drinkRepo.findAll();
    }

    public Optional<Drink> getDrinkById(String drinkId) {
        return drinkRepo.findById(drinkId);
    }

    public Drink updateDrink(Drink drink) {
        return drinkRepo.save(drink);
    }

    public void deleteDrink(String drinkId) {
        drinkRepo.deleteById(drinkId);
    }
}


