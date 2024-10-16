package com.Lookup.BrandMicroservice.Brand.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BrandResponseDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nit")
    private String nit;

    @JsonProperty("locations")
    private List<LocationResponseDTO> locations;
}
