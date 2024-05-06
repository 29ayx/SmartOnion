package com.smartonion.salt.model;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

import java.sql.Date;


@Document(collection = "familyInventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyInventory{
        @Id
        private String id;
        private String familyId;
        private String itemId;  // Reference to the Item in the catalog
        private float quantity;
//        private Date expiryDate;
        private boolean inStock;
    }



