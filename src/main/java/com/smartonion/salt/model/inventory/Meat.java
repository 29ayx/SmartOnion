package com.smartonion.salt.model.Inventory;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "meats")
public class Meat extends InventoryItem {
    private String type;  // e.g., Beef, Pork, Chicken
    private boolean isProcessed;  // True if it's processed meat
}
