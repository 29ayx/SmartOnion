package com.smartonion.salt.model.Inventory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fruits")
public class Fruit extends InventoryItem {
    private String color; // Additional attribute specific to fruits
}
