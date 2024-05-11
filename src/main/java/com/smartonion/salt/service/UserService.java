package com.smartonion.salt.service;


import java.util.List;
import java.util.UUID;

import com.smartonion.salt.model.Inventory.*;
import com.smartonion.salt.model.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartonion.salt.model.AdminUser;
import com.smartonion.salt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public AdminUser addUser(AdminUser user) {
        return repository.save(user);
    }
    

    public List<AdminUser> findAllUsers(){
        return repository.findAll();
    }



    public AdminUser findAdminUserByEmail(String email) {
//        return repository.findByEmail(email);
        return repository.findByEmail(email).orElse(null);

    }


    public void deleteUserByEmail(String id) {
        repository.deleteByEmail(id);
    }


    public List<UserInventory> getAllInventoryItems(String userId) {
        AdminUser user = repository.findByEmail(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getInventoryItems();  // Return the list of inventory items
    }

    public List<ShoppingList> getAllShoppingList(String userId) {
        AdminUser user = repository.findByEmail(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getShoppingList();  // Return the list of inventory items
    }


    //BACH
//    public ShoppingList getShoppingListById(String userId) {
//        AdminUser user = repository.findByEmail(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        return user.getShoppingListById();  // Return the list of inventory items
//    }

    public AdminUser addInventoryItemToUser(String userEmail, UserInventory item) {
        AdminUser user = repository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found")); // Now properly functional

        item.setAdminUser(user); // Assuming UserInventory has a back-reference to AdminUser
        user.getInventoryItems().add(item);
        return repository.save(user); // Saves the updated user with the new inventory item
    }


    public AdminUser addShoppingListToUser(String userEmail, ShoppingList list) {
        AdminUser user = repository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found")); // Now properly functional

        user.getShoppingList().add(list); // Assuming UserInventory has a back-reference to AdminUser
        return repository.save(user); // Saves the updated user with the new inventory item
    }


}
