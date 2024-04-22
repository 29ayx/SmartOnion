package com.smartonion.salt.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    private String userId;
    private String fullname;
    private String email;
    private String password;
    
}
