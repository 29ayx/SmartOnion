package com.smartonion.salt.service.inventory;

import com.smartonion.salt.model.inventory.Other;
import com.smartonion.salt.repository.inventory.OtherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OtherService {

    @Autowired
    private OtherRepository otherRepository;

    public Other getOtherById(String id) {
        return otherRepository.findById(id).orElse(null);
    }

    public Other createOther(Other other) {
        other.setItemId(UUID.randomUUID().toString().split("-")[0]);
        return otherRepository.save(other);
    }

    public List<Other> getAllOthers() {
        return otherRepository.findAll();
    }

    public Other updateOther(String id, Other other) {
        return otherRepository.existsById(id) ? otherRepository.save(other) : null;
    }

    public boolean deleteOther(String id) {
        if (otherRepository.existsById(id)) {
            otherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
