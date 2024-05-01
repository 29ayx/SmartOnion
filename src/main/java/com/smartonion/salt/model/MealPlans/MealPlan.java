package com.smartonion.salt.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Document(collection = "mealPlans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealPlan {
    @Id
    private String id;
    private String date;  // Date for which the meal plan is intended (could be LocalDate)
    private List<String> inventoryItemIds;  // List of IDs from the InventoryItem collection
    private List<String> mealRecipes;  // List of recipe names or IDs if linked to a Recipe collection
    private String familyId;  // ID to link to a family profile, if applicable

    // This can be expanded with more specific fields as needed, such as meal times, nutritional goals, etc.
}
