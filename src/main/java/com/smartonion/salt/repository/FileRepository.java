package com.smartonion.salt.repository;

import com.smartonion.salt.model.FileModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileModel, String> {
}