package com.Lookup.BrandMicroservice.Brand.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LocationCreationDTO {
    @JsonProperty("brand_id")
    private String brandId;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("local")
    private String local;

    @JsonProperty("name_of_place")
    private String nameOfPlace;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("latitude")
    private float latitude;

    @JsonProperty("longitude")
    private float longitude;
}
