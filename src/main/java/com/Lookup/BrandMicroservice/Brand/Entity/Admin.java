package com.Lookup.BrandMicroservice.Brand.Entity;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Field;


@Builder
public class Admin {
    @Field("user_name")
    private String userName;
    @Field("name")
    private String name;
    @Field("email")
    private String password;
}
