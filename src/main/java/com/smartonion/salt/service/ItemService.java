package com.smartonion.salt.service;


import com.smartonion.salt.model.Item;
import com.smartonion.salt.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item addItem(Item item){
        item.setItemId(UUID.randomUUID().toString().split("-")[0]);
        repository.save(item);
        return repository.save(item);
    }

    public List<Item> findAllItems(){
        return repository.findAll();
    }

    public Item getItemByItemId(String itemId){
        return repository.findById(itemId).get();
    }

    public Item updateItem(Item itemReqeust){
        Item existingItem = repository.findById(itemReqeust.getItemId()).get();
        existingItem.setName(itemReqeust.getName());
        existingItem.setType(itemReqeust.getType());
        existingItem.setQuantity(itemReqeust.getQuantity());

        return repository.save(existingItem);

    }

    public String deleteItem(String itemId){
        repository.deleteById(itemId);
        return "Item with id "+itemId+" has been deleted";
    }


}
