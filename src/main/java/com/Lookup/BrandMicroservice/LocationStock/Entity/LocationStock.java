package com.Lookup.BrandMicroservice.LocationStock.Entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Data
@Document("Location_Stock")
@Builder
public class LocationStock {
    @Id
    @Field("_id")
    private ObjectId id;

    @Field("items")
    private Map<String, ItemStock> item;
}
