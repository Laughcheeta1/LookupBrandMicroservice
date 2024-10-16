package com.Lookup.BrandMicroservice.Brand;

import com.Lookup.BrandMicroservice.Brand.Entity.Brand;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandDAO extends MongoRepository<Brand, ObjectId> {
}
