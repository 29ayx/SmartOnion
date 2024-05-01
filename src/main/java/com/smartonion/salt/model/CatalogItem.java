package com.smartonion.salt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "catalogItems")
public class CatalogItem {
    @Id
    private String itemId;
    private String name;
    private String type;
    private String unit; // Unit like "Kilograms", "Liters", etc.
}
