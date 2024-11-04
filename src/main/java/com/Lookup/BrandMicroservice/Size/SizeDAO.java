package com.Lookup.BrandMicroservice.Size;

import com.Lookup.BrandMicroservice.Size.Entity.Size;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SizeDAO extends MongoRepository<Size, String> {
    Optional<Size> findByName(String sizeName);
}
