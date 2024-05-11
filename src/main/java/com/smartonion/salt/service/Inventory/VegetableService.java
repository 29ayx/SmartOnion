package com.smartonion.salt.service.Inventory;

import com.smartonion.salt.model.inventory.Vegetable;
import com.smartonion.salt.repository.Inventory.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    public Vegetable getVegetableById(String id) {
        return vegetableRepository.findById(id).orElse(null);
    }

    public Vegetable createVegetable(Vegetable vegetable) {
        vegetable.setItemId(UUID.randomUUID().toString().split("-")[0]);
        return vegetableRepository.save(vegetable);
    }

    public List<Vegetable> getAllVegetables() {
        return vegetableRepository.findAll();
    }

    public Vegetable updateVegetable(String id, Vegetable vegetable) {
        return vegetableRepository.existsById(id) ? vegetableRepository.save(vegetable) : null;
    }

    public boolean deleteVegetable(String id) {
        if (vegetableRepository.existsById(id)) {
            vegetableRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
