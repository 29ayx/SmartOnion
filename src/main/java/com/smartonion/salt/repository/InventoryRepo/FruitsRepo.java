package com.smartonion.salt.repository.InventoryRepo;



import com.smartonion.salt.model.Inventory.Fruits; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitsRepo extends MongoRepository<Fruits, String> {
}
