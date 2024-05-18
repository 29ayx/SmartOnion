package com.smartonion.salt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FileModel {
    @Id
    private String id;
    private String name;
    private String type;
    private byte[] picByte;

    public FileModel(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    // getters and setters
}