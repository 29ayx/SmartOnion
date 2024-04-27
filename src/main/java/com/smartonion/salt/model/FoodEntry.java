package com.smartonion.salt.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "foodEntries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntry {

    @Id
    private String foodEntryId;
    private String itemId; // reference to the product consumed
    private int quantityConsumed;
    private Date dateConsumed;

    // Getters and Setters 

    public FoodEntry(String productId, int quantityConsumed, Date dateConsumed) {
        this.itemId = productId;
        this.quantityConsumed = quantityConsumed;
        this.dateConsumed = dateConsumed;
    }

}

