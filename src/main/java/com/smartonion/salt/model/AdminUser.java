package com.smartonion.salt.model;

import com.smartonion.salt.model.inventory.InventoryItem;
import com.smartonion.salt.model.inventory.UserInventory;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;  // Corrected import

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminUser {

    @Id
    private String id;
    private String email;
    private String fullname;
    private String password;
    private List<UserInventory> inventoryItems = new ArrayList<>();
    private List<ShoppingList> shoppingList = new ArrayList<>();


    public UserInventory getInventoryItemsById(String itemId) {
        return inventoryItems.stream()
                .filter(inventoryItem -> itemId.equals(inventoryItem.getItemId()))
                .findFirst()
                .orElse(null);
    }
}
