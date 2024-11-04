package com.Lookup.BrandMicroservice.Brand;

import com.Lookup.BrandMicroservice.Brand.DTO.BrandCreationDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.BrandResponseDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.LocationCreationDTO;

import java.util.List;

public interface BrandService {
    List<BrandResponseDTO> getAllBrands();

    BrandResponseDTO getBrand(String brandId);

    BrandResponseDTO createBrand(BrandCreationDTO brandCreationDTO);

    void updateBrand(String brandId, BrandCreationDTO brandCreationDTO);

    void deleteBrand(String brandId);

    void addLocation(String brandId, LocationCreationDTO locationCreationDTO);
}
