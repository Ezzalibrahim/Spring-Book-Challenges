package com.books.Controllers;

import com.books.Services.CloudinaryService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class ImageController {


    private CloudinaryService cloudinaryService;

    public ImageController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Map> upload(MultipartFile image) {
        try {
            if (image.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            String imageUrl = cloudinaryService.uploadFile(image, "books");
            if(imageUrl == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().body(Map.of("url", imageUrl));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
