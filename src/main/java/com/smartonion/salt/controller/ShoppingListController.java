package com.smartonion.salt.controller;

import com.smartonion.salt.model.ShoppingList;
import com.smartonion.salt.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppinglist")
public class ShoppingListController {
//
//    @Autowired
//    private ShoppingListService service;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ShoppingList createTask(@RequestBody ShoppingList shoppingList){
//        return service.addTask(shoppingList);
//    }
//
//
//    @GetMapping
//    public List<ShoppingList> getTasks(){
//        return service.findAllTasks();
//    }
//
//    @GetMapping("/{taskId}")
//    public ShoppingList getTask(@PathVariable String taskId){
//        return service.getTaskByTaskId(taskId);
//    }
//
//
//    @GetMapping("/severity/{severity}")
//    public List<ShoppingList> findTasksBySeverity(@PathVariable int severity){
//        return service.getTaskBySeverity(severity);
//    }
//
//    @PutMapping
//    public ShoppingList modifyTask(@RequestBody ShoppingList shoppingList){
//        return service.updateTask(shoppingList);
//    }
//
//    @DeleteMapping("/{taskId}")
//    public String deleteTask(@PathVariable String taskId){
//        return service.deleteTask(taskId);
//    }
//

}
