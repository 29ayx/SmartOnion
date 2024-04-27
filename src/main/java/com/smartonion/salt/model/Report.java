package com.smartonion.salt.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    private String reportId;
    private Date startDate;
    private Date endDate;
    private Map<String, Integer> totalConsumptionPerCategory; // Map stores category and total consumption
    private String nutritionalInformation; // JSON or formatted string containing nutritional data

    // Getters and Setters...

    public Report(Date startDate, Date endDate, Map<String, Integer> totalConsumptionPerCategory, String nutritionalInformation) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalConsumptionPerCategory = totalConsumptionPerCategory;
        this.nutritionalInformation = nutritionalInformation;
    }
}