package com.smartonion.salt.model.Inventory;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vegetables")
public class Vegetable extends FoodItem {
    private String color;  // Main color of the vegetable
}
