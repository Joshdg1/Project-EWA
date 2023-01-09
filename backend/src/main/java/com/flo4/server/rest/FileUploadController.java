package com.flo4.server.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flo4.server.models.FileUpload;
import com.flo4.server.models.User;
import com.flo4.server.repository.UserRepository;
import com.flo4.server.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/files")
@CrossOrigin(origins = "http://localhost:8080")
public class FileUploadController {

    @Autowired
    private final FileUploadService fileUploadService;

    @Autowired
    private final UserRepository userRepository;

    public FileUploadController(FileUploadService fileUploadService, UserRepository userRepository) {
        this.fileUploadService = fileUploadService;
        this.userRepository = userRepository;
    }

//    record FileUploadRequest(long id, MultipartFile file, int user_id) {
//    }
//
//    record FileUploadResponse(String msg) {
//    }

    @PostMapping("uploadFile")
    public FileUpload uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
     return fileUploadService.store(multipartFile);
    }
}
