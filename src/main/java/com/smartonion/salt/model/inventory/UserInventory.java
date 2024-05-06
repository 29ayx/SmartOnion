package com.smartonion.salt.model.Inventory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartonion.salt.model.AdminUser;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_inventory")
public class UserInventory extends InventoryItem {
    private boolean crucial;
    @DBRef
    @JsonIgnore
    private AdminUser adminUser;  // Link to the admin user
    private Map<String, Object> attributes; // For dynamic attributes

}
