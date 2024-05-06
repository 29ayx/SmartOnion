package com.smartonion.salt.model.Inventory;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "others")
public class Other extends FoodItem {
    private String category;  // To specify further if it's a snack, condiment, etc.
}
