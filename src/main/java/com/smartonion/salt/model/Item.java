package com.smartonion.salt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    private String itemId;
    private String name;
    private String type;
    private float Calories;
    private int quantity;
    private Date expiryDate;
    private boolean stock;

}
