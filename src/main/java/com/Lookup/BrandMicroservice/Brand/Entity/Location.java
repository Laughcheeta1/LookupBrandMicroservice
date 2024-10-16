package com.Lookup.BrandMicroservice.Brand.Entity;

import com.Lookup.BrandMicroservice.LocationStock.Entity.LocationStock;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

public class Location {
    @Field("direction")
    private String direction;

    @Field("local")
    private String local;

    @Field("name_of_place")
    private String nameOfPlace;

    @Field("city")
    private String city;

    @Field("state")
    private String state;

    @Field("country")
    private String country;

    @Field("latitude")
    private float latitude;

    @Field("longitude")
    private float longitude;

    @DBRef(lazy = true)
    @Field("stock")
    private LocationStock stock;
}
