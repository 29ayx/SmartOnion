package com.smartonion.salt.service;


import com.smartonion.salt.model.Task;
import com.smartonion.salt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    //CRUD


    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        repository.save(task);
        return repository.save(task);
    }

    public List<Task> findAllTasks(){
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return repository.findBySeverity(severity);
    }


    public Task updateTask(Task taskReqeust){
        Task existingtask = repository.findById(taskReqeust.getTaskId()).get();
        existingtask.setDescription(taskReqeust.getDescription());
        existingtask.setSeverity(taskReqeust.getSeverity());
        existingtask.setAssigned(taskReqeust.getAssigned());
        existingtask.setStoryPoint(taskReqeust.getStoryPoint());

        return repository.save(existingtask);

    }


    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return "Task with id "+taskId+" has been deleted";
    }

}
