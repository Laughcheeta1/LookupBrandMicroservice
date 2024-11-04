package com.Lookup.BrandMicroservice.Brand;

import com.Lookup.BrandMicroservice.Brand.DTO.BrandCreationDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.BrandResponseDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.LocationCreationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandController {
    ResponseEntity<List<BrandResponseDTO>> getAllBrands();

    ResponseEntity<BrandResponseDTO> getBrand(String brandId);

    ResponseEntity<BrandResponseDTO> createBrand(BrandCreationDTO brandCreationDTO);

    ResponseEntity<Void> updateBrand(String brandId, BrandCreationDTO brandCreationDTO);

    ResponseEntity<Void> deleteBrand(String brandId);

    ResponseEntity<Void> addLocation(String brandId, LocationCreationDTO locationCreationDTO);
}
