package com.smartonion.salt.model.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartonion.salt.model.AdminUser;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_inventory")
public class UserInventory extends InventoryItem {
    private boolean crucial;
//    private String type;
    private float notifyBefore;
    @DBRef
    @JsonIgnore
    private AdminUser adminUser;  // Link to the admin user

}
