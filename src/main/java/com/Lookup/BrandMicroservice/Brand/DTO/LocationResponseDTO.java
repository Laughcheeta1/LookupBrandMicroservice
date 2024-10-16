package com.Lookup.BrandMicroservice.Brand.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationResponseDTO {
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

    @JsonProperty("stock_id")
    private String stockId;
}