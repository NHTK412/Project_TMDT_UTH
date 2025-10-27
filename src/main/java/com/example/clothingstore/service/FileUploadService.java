package com.example.clothingstore.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.clothingstore.dto.fileupload.FileUploadResponse;

@Service
public class FileUploadService {

    @Value("${image-upload-path}")
    private String imagePathString;

    public FileUploadResponse uploadImage(MultipartFile file) throws IOException {

        String originalFileName = file.getOriginalFilename();

        // Tạo một tên file duy nhất bằng cách thêm Timestamp vào.
        // Ví dụ: 20251027150000_originalFileName.jpg
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String newFileName = timestamp + "_" + originalFileName;

        // Paths.get(chuỗi_đường_dẫn_gốc, tên_file_mới)
        // Phương thức resolve() giúp nối đường dẫn một cách an toàn.
        Path destinationPath = Paths.get(imagePathString).resolve(newFileName);

        // Nếu thư mục không tồn tại, tạo nó
        Files.createDirectories(destinationPath.getParent());

        // Thực hiện lưu file
        file.transferTo(destinationPath);

        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        fileUploadResponse.setFileName(newFileName);
        fileUploadResponse.setFileName(destinationPath.toString());

        return fileUploadResponse;
    }

    public FileUploadResponse deleteImage(String fileName) {
        FileUploadResponse fileUploadResponse = new FileUploadResponse();

        Path destinationPath = Paths.get(imagePathString).resolve(fileName);

        File image = destinationPath.toFile();

        fileUploadResponse.setFileName(image.getName());
        fileUploadResponse.setFilePath(image.getPath());

        image.delete();

        return fileUploadResponse;
    }
}
