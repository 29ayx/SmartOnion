package com.smartonion.salt.repository;

import com.smartonion.salt.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {


    List<Task> findBySeverity(int severity);
}
