package com.smartonion.salt.service.InventoryService;

import com.smartonion.salt.model.Inventory.Sauce;
import com.smartonion.salt.repository.InventoryRepo.SauceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SauceService {

    @Autowired
    private SauceRepo sauceRepo;

    // CRUD Methods

    public Sauce createSauce(Sauce sauce) {
        return sauceRepo.save(sauce);
    }

    public List<Sauce> getAllSauces() {
        return sauceRepo.findAll();
    }

    public Optional<Sauce> getSauceById(String sauceId) {
        return sauceRepo.findById(sauceId);
    }

    public Sauce updateSauce(Sauce sauce) {
        return sauceRepo.save(sauce);
    }

    public void deleteSauce(String sauceId) {
        sauceRepo.deleteById(sauceId);
    }
}
