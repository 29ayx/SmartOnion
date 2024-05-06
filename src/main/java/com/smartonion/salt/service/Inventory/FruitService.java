package com.smartonion.salt.service.Inventory;

import com.smartonion.salt.model.Inventory.Fruit;
import com.smartonion.salt.repository.Inventory.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit getFruitById(String id) {
        return fruitRepository.findById(id).orElse(null);
    }

    public Fruit createFruit(Fruit fruit) {
        fruit.setItemId(UUID.randomUUID().toString().split("-")[0]);
        return fruitRepository.save(fruit);
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit updateFruit(String id, Fruit fruit) {
        return fruitRepository.existsById(id) ? fruitRepository.save(fruit) : null;
    }

    public boolean deleteFruit(String id) {
        if (fruitRepository.existsById(id)) {
            fruitRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
