
package com.smartonion.salt.model.MealPlans;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private String id;
    

    // This can be expanded with more specific fields as needed, such as meal times, nutritional goals, etc.
}
