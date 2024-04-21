package com.smartonion.salt.controller;

import com.smartonion.salt.model.Item;
import com.smartonion.salt.model.Task;
import com.smartonion.salt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@RequestBody Item item)
    {return service.addItem(item);}

    @GetMapping
    public List<Item> getItems(){
        return service.findAllItems();
    }

    @PutMapping("/{itemId}")
    public Item modifyItem(@RequestBody Item item){
        return service.updateItem(item);
    }

    @DeleteMapping("/{itemId}")
    public String deleteTask(@PathVariable String itemId){
        return service.deleteItem(itemId);

        ;;
    }


}
