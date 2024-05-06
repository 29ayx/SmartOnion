package com.smartonion.salt.model.Profile;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "foodPreferences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodPreference {
    @Id
    private String id;
    private String preferenceType;  // e.g., Vegetarian, Vegan, Meat Lover, etc.
}
