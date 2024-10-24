package com.Lookup.BrandMicroservice.Brand.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BrandCreationDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("nit")
    private String nit;
    @JsonProperty("principal_admin")
    private PrincipalAdminCreationDTO principalAdmin;
}
