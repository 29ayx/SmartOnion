package com.smartonion.salt.model.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "others")
public class Other extends InventoryItem {
    private String specialAttribute; // Additional attribute specific to Other
}
