package com.Lookup.BrandMicroservice.LocationStock.Entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Size {
    @Field("size")
    private String sizeId;

    @Field("quantity")
    private int quantity;
}
