package com.smartonion.salt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "inventoryItems")
public class InventoryItem {
    @Id
    private String inventoryId; // Unique ID for each inventory entry
    private String itemId; // Reference to the CatalogItem ID
    private float quantity;
//    private Date expiryDate;
    private boolean inStock;
}
