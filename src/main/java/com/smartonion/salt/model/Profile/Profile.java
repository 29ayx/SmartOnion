package com.smartonion.salt.model.Profile;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    private int id;
    private String picture;
    private String name;
    private Date dob;
    private FoodPreference preferenceType;
    private DietaryRestriction restriction;
    private Allergies allergies;

}
