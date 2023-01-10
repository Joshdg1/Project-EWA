package com.flo4.server.service;

import com.flo4.server.models.FileUpload;
import com.flo4.server.models.User;
import com.flo4.server.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadService {


    @Autowired
    private FileUploadRepository fileUploadRepository;

    public FileUpload store(MultipartFile file) throws IOException {
        FileUpload fileUpload = new FileUpload();


        String id = UUID.randomUUID().toString();
        String fileName = file.getOriginalFilename();
        String type = file.getContentType();
        byte[] data  = file.getBytes();

        fileUpload.setId(id);
        fileUpload.setName(fileName);
        fileUpload.setType(type);
        fileUpload.setData(data);
//        fileUpload.setUser_id(userId);

         fileUploadRepository.save(fileUpload);
        return null;
    }

}
