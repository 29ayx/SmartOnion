package com.smartonion.salt.controller.Inventory;

import com.smartonion.salt.model.inventory.Other;
import com.smartonion.salt.service.Inventory.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory/others")
public class OtherController {

    @Autowired
    private OtherService otherService;

    @GetMapping("/{id}")
    public ResponseEntity<Other> getOtherById(@PathVariable String id) {
        Other other = otherService.getOtherById(id);
        return other != null ? ResponseEntity.ok(other) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Other> createOther(@RequestBody Other other) {
        Other savedOther = otherService.createOther(other);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOther);
    }

    @GetMapping
    public ResponseEntity<List<Other>> getAllOthers() {
        List<Other> others = otherService.getAllOthers();
        return ResponseEntity.ok(others);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Other> updateOther(@PathVariable String id, @RequestBody Other other) {
        Other updatedOther = otherService.updateOther(id, other);
        return updatedOther != null ? ResponseEntity.ok(updatedOther) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOther(@PathVariable String id) {
        if (otherService.deleteOther(id)) {
            return ResponseEntity.ok("Other deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Other not found");
        }
    }
}
