package com.smartonion.salt.controller.Inventory;

        import com.smartonion.salt.model.Inventory.Fruit;
        import com.smartonion.salt.service.Inventory.FruitService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/inventory/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable String id) {
        Fruit fruit = fruitService.getFruitById(id);
        return fruit != null ? ResponseEntity.ok(fruit) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.createFruit(fruit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFruit);
    }

    @GetMapping
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        return ResponseEntity.ok(fruits);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable String id, @RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruit(id, fruit);
        return updatedFruit != null ? ResponseEntity.ok(updatedFruit) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable String id) {
        if (fruitService.deleteFruit(id)) {
            return ResponseEntity.ok("Fruit deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found");
        }
    }
}
