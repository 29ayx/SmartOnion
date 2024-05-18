package com.smartonion.salt.controller;

import com.smartonion.salt.model.inventory.InventoryItem;
import com.smartonion.salt.model.inventory.UserInventory;
import com.smartonion.salt.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory")
public class InventoryItemController {

   @Autowired
   InventoryItemRepository repository;



}
