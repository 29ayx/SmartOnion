package com.smartonion.salt.model;

import com.smartonion.salt.model.inventory.Fruit;
import com.smartonion.salt.model.inventory.Other;
import com.smartonion.salt.model.inventory.UserInventory;
import com.smartonion.salt.model.inventory.Vegetable;
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
//    private List<UserInventory> inventoryItems;  // List of inventory items
    private List<UserInventory> inventoryItems = new ArrayList<>();
//    private List<Fruit> fruits = new ArrayList<>();
//    private List<Vegetable> vegetables = new ArrayList<>();
//    private List<Other> others = new ArrayList<>();


}
