package com.smartonion.salt.controller;
import com.smartonion.salt.model.CatalogItem;
import com.smartonion.salt.model.InventoryItem;

import com.smartonion.salt.model.Item;
import com.smartonion.salt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/items")

public class ItemController {


    @Autowired
    private ItemService service;


    @PostMapping("/catalog")
    public CatalogItem addCatalogItem(@RequestBody CatalogItem item) {
        return service.addCatalogItem(item);
    }

    @PostMapping("/inventory")
    public InventoryItem addInventoryItem(@RequestBody InventoryItemRequest request) {
        return service.addOrUpdateInventoryItem(request.getItemId(), request.getQuantity(), request.getExpiryDate());
    }


    @GetMapping("/inventory")
    public List<InventoryItem> getAllInventoryItems() {
        return service.getAllInventoryItems();
    }

    @GetMapping("/catalog")
    public List<CatalogItem> getAllCatalogItems() {
        return service.getAllCatalogItems();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return service.addItem(item);
    }

    @GetMapping
    public List<Item> getItems() {
        return service.findAllItems();
    }

    @GetMapping("/type/{type}")
    public List<Item> getItemsByType(@PathVariable String type) {
        return service.getItemsByType(type);
    }

    @GetMapping("/name/{name}")
    public List<Item> getItemsByName(@PathVariable String name) {
        return service.getItemsByName(name);
    }

    @GetMapping("/expired")
    public List<Item> getExpiredItems() {
        return service.getExpiredItems();
    }

    @GetMapping("/low-stock")
    public List<Item> getItemsWithLowStock(@RequestParam(defaultValue = "5") int threshold) {
        return service.getItemsWithLowStock(threshold);
    }

    @PutMapping
    public Item modifyItem(@RequestBody Item item) {
        return service.updateItem(item);
    }

    @DeleteMapping("/{itemId}")
    public String deleteItem(@PathVariable String itemId) {
        return service.deleteItem(itemId);
    }

//    public List<Item> getItemsByType(@PathVariable Item.ItemType type) {
//        return service.getItemsByType(type);
//    }
}

