package com.smartonion.salt.controller;

import com.smartonion.salt.model.FileModel;
import com.smartonion.salt.repository.FileRepository;
import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;

        import java.io.IOException;

@Controller
@RequestMapping("/api/files")
public class FileUpload {

    @Autowired
    private FileRepository fileRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            fileRepository.save(fileModel);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload the file: " + e.getMessage());
        }
    }
}
