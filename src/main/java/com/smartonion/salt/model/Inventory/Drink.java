package com.smartonion.salt.model.Inventory;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drinks")
public class Drink extends FoodItem {
    private boolean isAlcoholic;  // True if the drink contains alcohol
}
