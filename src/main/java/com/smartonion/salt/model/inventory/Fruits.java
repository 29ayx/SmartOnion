package com.smartonion.salt.model.Inventory;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruits")
public class Fruits extends FoodItem {
    private String season;  // Season in which the fruit is typically available
}
