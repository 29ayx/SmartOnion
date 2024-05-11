package com.smartonion.salt.model.inventory;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class InventoryItem {
    @Id
    private String itemId;
    private String name;
    private String expiryDate;  // considered as a String for simplicity, can be LocalDate
}

