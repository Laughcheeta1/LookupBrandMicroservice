package com.Lookup.BrandMicroservice.Brand;

import com.Lookup.BrandMicroservice.Brand.DTO.BrandCreationDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.BrandResponseDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.LocationCreationDTO;
import com.Lookup.BrandMicroservice.Brand.Entity.Brand;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandControllerImplementation implements BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandControllerImplementation(BrandService brandService)
    {
        this.brandService= brandService;
    }

    @Override
    public ResponseEntity<List<BrandResponseDTO>> getAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @Override
    public ResponseEntity<BrandResponseDTO> getBrand(String brandId) {
        return ResponseEntity.ok(brandService.getBrand(brandId));
    }

    @Override
    public ResponseEntity<BrandResponseDTO> createBrand(BrandCreationDTO brandCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.createBrand(brandCreationDTO));
    }

    @Override
    public ResponseEntity<Void> updateBrand(String brandId, BrandCreationDTO brandCreationDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteBrand(String brandId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> addLocation(LocationCreationDTO locationCreationDTO) {
        return null;
    }
}
