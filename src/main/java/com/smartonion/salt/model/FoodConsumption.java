package com.smartonion.salt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "food_consumption")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodConsumption {

    private String familyId;
    private String profileId;
    private String itemName;
    private float item_quantity;
    private float item_calories;

}
