package com.jetbrains.nax.photozclone.web;

import com.jetbrains.nax.photozclone.service.PhotoService;
import com.jetbrains.nax.photozclone.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {

    private PhotoService photoService;


    public PhotozController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get() {
        return photoService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if(photo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }

}
