package com.smartonion.salt.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.util.Date;

@Document(collection = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Profile {

    @Id
    private String profileId;
    private String userEmail;
    private Date dob;
    private String name;
    private int dietgoal;
    private String allergies;


}
