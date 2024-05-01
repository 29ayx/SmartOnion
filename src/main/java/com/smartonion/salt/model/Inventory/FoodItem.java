package com.smartonion.salt.model.Inventory;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class FoodItem {
    @Id
    private String id;
    private String name;
    private double quantity;  // in units appropriate to the item (pieces, grams, liters, etc.)
    private int calories;  // per serving
    private String expiryDate;  // considered as a String for simplicity, can be LocalDate
    private String nutrition;  // basic nutrition information
}
