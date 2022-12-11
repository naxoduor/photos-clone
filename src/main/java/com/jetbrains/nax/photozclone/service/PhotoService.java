package com.jetbrains.nax.photozclone.service;

import com.jetbrains.nax.photozclone.model.Photo;
import com.jetbrains.nax.photozclone.repository.PhotozRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PhotoService {
    HashMap<String, Photo> db;
    private PhotozRepository photozRepository;

    public PhotoService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id){
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
         photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }

}
