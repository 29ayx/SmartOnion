package com.smartonion.salt.controller;

import com.smartonion.salt.model.AdminUser;
import com.smartonion.salt.model.Profile;
import com.smartonion.salt.model.inventory.UserInventory;
import com.smartonion.salt.service.InventoryService;
import com.smartonion.salt.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

   @Autowired
   private InventoryService inventoryService;

   @Autowired
   private ProfileService profileService;

   // Get all inventory items for a user by email
   @GetMapping("/{email}")
   public ResponseEntity<?> getAllInventoryItems(@PathVariable String email) {
      List<UserInventory> inventoryItems = inventoryService.getAllInventoryItems(email);
      if (inventoryItems == null || inventoryItems.isEmpty()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No items available in inventory.");
      }
      return ResponseEntity.ok(inventoryItems);
   }

   // Get item by ID and user email
   @GetMapping("/{email}/{itemId}")
   public ResponseEntity<UserInventory> getItemById(@PathVariable String email, @PathVariable String itemId) {
      Optional<UserInventory> item = inventoryService.getInventoryItemById(email, itemId);
      return item.map(ResponseEntity::ok)
              .orElseGet(() -> ResponseEntity.notFound().build());
   }

   // Add or update inventory item by user email
   @PostMapping("/{email}")
   public ResponseEntity<?> addOrUpdateInventoryItem(@PathVariable String email, @RequestBody UserInventory item) {
      Optional<AdminUser> user = inventoryService.addOrUpdateInventoryItem(email, item);
      if (user.isPresent()) {
         return ResponseEntity.ok(user.get());
      } else {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
      }
   }

   // Delete item by ID and user email
   @DeleteMapping("/{email}/{itemId}")
   public ResponseEntity<Void> deleteItemById(@PathVariable String email, @PathVariable String itemId) {
      if (inventoryService.deleteInventoryItemById(email, itemId)) {
         return ResponseEntity.noContent().build();
      } else {
         return ResponseEntity.notFound().build();
      }
   }




   // Consume item by profile ID and item ID
   @PostMapping("/consume/{profileId}/{itemId}")
   public ResponseEntity<?> consumeItem(@PathVariable String profileId, @PathVariable String itemId, @RequestParam float quantity) {
      Optional<UserInventory> item = profileService.consumeItemByProfileId(profileId, itemId, quantity);
      if (item.isPresent()) {
         return ResponseEntity.ok(item.get());
      } else {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item not found or insufficient quantity");
      }
   }
}
