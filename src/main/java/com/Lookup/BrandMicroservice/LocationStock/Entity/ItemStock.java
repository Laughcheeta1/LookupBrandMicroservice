package com.Lookup.BrandMicroservice.LocationStock.Entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Getter
public class ItemStock {
    @Field("sizes")
    private Map<String, Integer> sizes;
}
