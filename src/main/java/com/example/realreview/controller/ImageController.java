package com.example.realreview.controller;

import com.example.realreview.model.ImageMetadata;
import com.example.realreview.repository.ImageMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageMetadataRepository repository;

    private final String uploadDir = "uploads"; // folder to save images

    // POST API: Upload image and metadata
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("uploader") String uploader,
            @RequestParam("location") String location
    ) {
        try {
            // Create upload directory if not exists
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            // Save the image to disk
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File dest = new File(dir, fileName);
            file.transferTo(dest);

            // Create and save image metadata record
            ImageMetadata imageMetadata = new ImageMetadata(uploader, fileName, location, LocalDateTime.now());
            repository.save(imageMetadata);

            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading file.");
        }
    }

    // GET API: List all image metadata
    @GetMapping
    public List<ImageMetadata> getAllImages() {
        return repository.findAll();
    }

    // GET API: Get image metadata by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getImageById(@PathVariable Long id) {
        return repository.findById(id)
                .map(image -> ResponseEntity.ok(image))
                .orElse(ResponseEntity.notFound().build());
    }
}
