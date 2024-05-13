package com.smartonion.salt.model.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vegetables")
public class Vegetable extends InventoryItem {
    private String color; // Additional attribute specific to vegetables
}
