package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.clothingstore.dto.fileupload.FileUploadResponse;
import com.example.clothingstore.service.FileUploadService;
import com.example.clothingstore.util.ApiResponse;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("file-upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    // Consumer để nói kiểu gửi lên
    @PostMapping(value = "/image", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponse<FileUploadResponse>> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            FileUploadResponse fileUploadResponse = fileUploadService.uploadImage(file);
            return ResponseEntity.ok(new ApiResponse<>(true, null, fileUploadResponse));
        } catch (IOException e) {
            return ResponseEntity.status(500)
                    .body(new ApiResponse<>(false, "Unable to save file due to I/O error:" + e.getMessage(), null));
        }
    }

    @PostMapping(value = "/multiple", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponse<List<FileUploadResponse>>> uploadMultipleImage(@RequestParam("files") List<MultipartFile> files) {
        
          try {
            List<FileUploadResponse> fileUploadResponses = fileUploadService.uploadMultipleImage(files);
            return ResponseEntity.ok(new ApiResponse<>(true, null, fileUploadResponses));
        } catch (IOException e) {
            return ResponseEntity.status(500)
                    .body(new ApiResponse<>(false, "Unable to save file due to I/O error:" + e.getMessage(), null));
        }
    }
    

    @DeleteMapping("/{fileName}")
    public ResponseEntity<ApiResponse<FileUploadResponse>> deleteImage(@PathVariable String fileName) {
        FileUploadResponse fileUploadResponse = fileUploadService.deleteImage(fileName);
        return ResponseEntity.ok(new ApiResponse<>(true, null, fileUploadResponse));
    }


}
