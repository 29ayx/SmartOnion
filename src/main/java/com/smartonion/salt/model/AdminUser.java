package com.smartonion.salt.model;

import com.smartonion.salt.model.Inventory.Fruit;
import com.smartonion.salt.model.Inventory.Other;
import com.smartonion.salt.model.Inventory.UserInventory;
import com.smartonion.salt.model.Inventory.Vegetable;
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

//    private List<UserInventory> inventoryItems;  // List of inventory items
//    private List<Fruit> fruits = new ArrayList<>();
//    private List<Vegetable> vegetables = new ArrayList<>();
//    private List<Other> others = new ArrayList<>();


}
