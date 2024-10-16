package com.Lookup.BrandMicroservice.LocationStock;

import com.Lookup.BrandMicroservice.LocationStock.Entity.LocationStock;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationStockDAO extends MongoRepository<LocationStock, ObjectId> {
}
