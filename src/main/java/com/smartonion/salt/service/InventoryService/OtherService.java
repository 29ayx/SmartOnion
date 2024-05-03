package com.smartonion.salt.service.InventoryService;

import com.smartonion.salt.model.Inventory.Other;
import com.smartonion.salt.repository.InventoryRepo.OtherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherService {

    @Autowired
    private OtherRepo otherItemRepo;

    // CRUD Methods

    public Other createOtherItem(Other otherItem) {
        return otherItemRepo.save(otherItem);
    }

    public List<Other> getAllOtherItems() {
        return otherItemRepo.findAll();
    }

    public Optional<Other> getOtherItemById(String otherItemId) {
        return otherItemRepo.findById(otherItemId);
    }

    public Other updateOtherItem(Other otherItem) {
        return otherItemRepo.save(otherItem);
    }

    public void deleteOtherItem(String otherItemId) {
        otherItemRepo.deleteById(otherItemId);
    }
}
