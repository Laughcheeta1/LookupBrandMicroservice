package com.Lookup.BrandMicroservice.Brand.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrincipalAdminCreationDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("password")
    private String password;
}
