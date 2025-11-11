package com.example.clothingstore.dto.fileupload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadResponseDTO {

    private String fileName;

    private String filePath;
}