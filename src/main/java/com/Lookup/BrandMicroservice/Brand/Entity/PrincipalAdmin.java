package com.Lookup.BrandMicroservice.Brand.Entity;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
public class PrincipalAdmin {
    @Field("name")
    private String name;

    @Field("email")
    private String password;

    @Field("email")
    private String email;

    @Field("phone_number")
    private String phoneNumber;
}
