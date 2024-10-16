package com.Lookup.BrandMicroservice.LocationStock.Entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class ItemStock {
    @Field("item")
    private String itemId;

    @Field("sizes")
    private List<Size> sizes;

}
