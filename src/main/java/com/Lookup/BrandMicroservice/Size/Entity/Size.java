package com.Lookup.BrandMicroservice.Size.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Size")
public class Size {
    @Id
    @Field("_id")
    private ObjectId id;

    @Field("name")
    private String name;
}
