package com.smartonion.salt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.List;

@Document(collection = "shoppinglist")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShoppingList {

    @Id
    private String shoppingListId;
    private String description;
    private Date shoppingDate;
    private List<ShoppingItem> shoppingItems;


}

