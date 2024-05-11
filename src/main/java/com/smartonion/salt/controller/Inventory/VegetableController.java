package com.smartonion.salt.controller.Inventory;

import com.smartonion.salt.model.inventory.Vegetable;
import com.smartonion.salt.service.Inventory.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory/vegetables")
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @GetMapping("/{id}")
    public ResponseEntity<Vegetable> getVegetableById(@PathVariable String id) {
        Vegetable vegetable = vegetableService.getVegetableById(id);
        return vegetable != null ? ResponseEntity.ok(vegetable) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Vegetable> createVegetable(@RequestBody Vegetable vegetable) {
        Vegetable savedVegetable = vegetableService.createVegetable(vegetable);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVegetable);
    }

    @GetMapping
    public ResponseEntity<List<Vegetable>> getAllVegetables() {
        List<Vegetable> vegetables = vegetableService.getAllVegetables();
        return ResponseEntity.ok(vegetables);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vegetable> updateVegetable(@PathVariable String id, @RequestBody Vegetable vegetable) {
        Vegetable updatedVegetable = vegetableService.updateVegetable(id, vegetable);
        return updatedVegetable != null ? ResponseEntity.ok(updatedVegetable) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVegetable(@PathVariable String id) {
        if (vegetableService.deleteVegetable(id)) {
            return ResponseEntity.ok("Vegetable deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vegetable not found");
        }
    }
}
