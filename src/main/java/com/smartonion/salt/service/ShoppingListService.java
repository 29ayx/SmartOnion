package com.smartonion.salt.service;


import com.smartonion.salt.model.ShoppingList;
import com.smartonion.salt.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListService {
//
//    @Autowired
//    private ShoppingListRepository repository;
//
//    //CRUD
//
//
//    public ShoppingList addTask(ShoppingList shoppingList){
//        shoppingList.setTaskId(UUID.randomUUID().toString().split("-")[0]);
//        repository.save(shoppingList);
//        return repository.save(shoppingList);
//    }
//
//    public List<ShoppingList> findAllTasks(){
//        return repository.findAll();
//    }
//
//    public ShoppingList getTaskByTaskId(String taskId){
//        return repository.findById(taskId).get();
//    }
//
//    public List<ShoppingList> getTaskBySeverity(int severity){
//        return repository.findBySeverity(severity);
//    }
//
//
//
//
//    public String deleteTask(String taskId){
//        repository.deleteById(taskId);
//        return "Task with id "+taskId+" has been deleted";
//    }

}
