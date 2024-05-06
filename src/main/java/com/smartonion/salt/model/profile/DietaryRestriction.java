package com.smartonion.salt.model.Profile;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "dietaryRestrictions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietaryRestriction {
    @Id
    private String id;
    private String restrictionType;  // e.g., Gluten-free, Dairy-free, Nut-free, etc.
}
