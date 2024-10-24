package com.Lookup.BrandMicroservice.Brand;

import com.Lookup.BrandMicroservice.Brand.DTO.BrandCreationDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.BrandResponseDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.LocationCreationDTO;
import com.Lookup.BrandMicroservice.Brand.Entity.Brand;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("")
    public ResponseEntity<List<BrandResponseDTO>> getAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @Override
    @GetMapping("/{brandId}")
    public ResponseEntity<BrandResponseDTO> getBrand(@PathVariable("brandId") String brandId) {
        return ResponseEntity.ok(brandService.getBrand(brandId));
    }

    @Override
    @PostMapping
    public ResponseEntity<BrandResponseDTO> createBrand(@RequestBody BrandCreationDTO brandCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.createBrand(brandCreationDTO));
    }

    @Override
    @PutMapping("/{brandId}")
    public ResponseEntity<Void> updateBrand(@PathVariable("brandId") String brandId, @RequestBody BrandCreationDTO brandCreationDTO) {
        return null;
    }

    @Override
    @DeleteMapping("/{brandId}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("brandId") String brandId) {
        return null;
    }

    @Override
    @PostMapping("/location")
    public ResponseEntity<Void> addLocation(@RequestBody LocationCreationDTO locationCreationDTO) {
        return null;
    }
}
