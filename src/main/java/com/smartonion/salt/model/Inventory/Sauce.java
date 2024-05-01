package com.smartonion.salt.model.Inventory;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sauces")
public class Sauce extends FoodItem {
    private String baseIngredient;  // Primary ingredient, e.g., Tomato, Soy, etc.
}
