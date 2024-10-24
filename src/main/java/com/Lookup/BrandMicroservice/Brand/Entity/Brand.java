package com.Lookup.BrandMicroservice.Brand.Entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("Brand")
@Data
@Builder
public class Brand {
    @Id
    @Field("_id")
    private ObjectId id;

    @Field("name")
    private String name;

    @Field("email")
    private String nit;

    @Field("admins")
    private List<Admin> admins;

    @Field("principal_admin")
    private PrincipalAdmin principalAdmin;

    @Field("locations")
    private List<Location> locations;
}
