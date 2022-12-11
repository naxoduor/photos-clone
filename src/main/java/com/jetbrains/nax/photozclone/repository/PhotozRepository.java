package com.jetbrains.nax.photozclone.repository;

import com.jetbrains.nax.photozclone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {
}
