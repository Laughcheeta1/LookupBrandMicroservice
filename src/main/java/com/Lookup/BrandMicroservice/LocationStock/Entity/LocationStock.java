package com.Lookup.BrandMicroservice.LocationStock.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document("Location_Stock")
public class LocationStock {
    @Id
    @Field("_id")
    private ObjectId id;

    @Field("items")
    private List<ItemStock> items;
}
