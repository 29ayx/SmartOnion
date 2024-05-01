package com.smartonion.salt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    private String itemId;
    private String name;
    private String type;  // Changed from enum to String
    private float quantity;
    private String unit;  // Changed from enum to String
    private Date expiryDate;
    private boolean inStock;
}
