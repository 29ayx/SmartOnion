package com.smartonion.salt.model.Profile;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "allergies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allergies {
    @Id
    private String id;
    private String allergyName;
}
