package com.smartonion.salt.service;

import com.smartonion.salt.model.Item;
import com.smartonion.salt.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartonion.salt.model.CatalogItem;
import com.smartonion.salt.model.InventoryItem;
import com.smartonion.salt.repository.CatalogItemRepository;
import com.smartonion.salt.repository.InventoryItemRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ItemService {


    @Autowired
    private ItemRepository repository;

        // Add these new properties to the existing ItemService class
    @Autowired
    private CatalogItemRepository catalogItemRepository;

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    // Add new methods to the existing ItemService class
    public CatalogItem addCatalogItem(CatalogItem item) {
        return catalogItemRepository.save(item);
    }

    public InventoryItem addOrUpdateInventoryItem(String itemId, float quantity, Date expiryDate) {
        Optional<InventoryItem> existingInventory = inventoryItemRepository.findByItemId(itemId).stream().findFirst();
        if (existingInventory.isPresent()) {
            InventoryItem inventoryItem = existingInventory.get();
            inventoryItem.setQuantity(inventoryItem.getQuantity() + quantity);
            inventoryItem.setExpiryDate(expiryDate);
            inventoryItem.setInStock(true);
            return inventoryItemRepository.save(inventoryItem);
        } else {
            InventoryItem newInventoryItem = new InventoryItem(null, itemId, quantity, expiryDate, true);
            return inventoryItemRepository.save(newInventoryItem);
        }
    }
    
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemRepository.findAll();
    }
    
    public List<CatalogItem> getAllCatalogItems() {
        return catalogItemRepository.findAll();
    }
    


    public List<Item> findAllItems(){
        return repository.findAll();
    }

    public List<Item> getItemsByType(String type){
        return repository.findByType(type);
    }

    public List<Item> getItemsByName(String name){
        return repository.findByName(name);
    }

    public Item addItem(Item item){
        item.setItemId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(item);
    }

    public Item getItemByItemId(String itemId){
        return repository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
    }

    public List<Item> getExpiredItems() {
        return repository.findExpiredItems(new Date());
    }

    public List<Item> getItemsWithLowStock(int threshold){
        return repository.findItemsWithLowStock(threshold);
    }
    public Item updateItem(Item itemRequest){
        Item existingItem = repository.findById(itemRequest.getItemId()).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        existingItem.setName(itemRequest.getName());
        existingItem.setType(itemRequest.getType());
        existingItem.setQuantity(itemRequest.getQuantity());
        existingItem.setUnit(itemRequest.getUnit());
        existingItem.setExpiryDate(itemRequest.getExpiryDate());
        existingItem.setInStock(itemRequest.isInStock());
        return repository.save(existingItem);
    }
    public String deleteItem(String itemId){
        repository.deleteById(itemId);
        return "Item with id " + itemId + " has been deleted";
    }


}
