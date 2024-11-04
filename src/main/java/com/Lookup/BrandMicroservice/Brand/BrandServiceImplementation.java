package com.Lookup.BrandMicroservice.Brand;

import com.Lookup.BrandMicroservice.Brand.DTO.BrandCreationDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.BrandResponseDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.LocationCreationDTO;
import com.Lookup.BrandMicroservice.Brand.DTO.LocationResponseDTO;
import com.Lookup.BrandMicroservice.Brand.Entity.Brand;
import com.Lookup.BrandMicroservice.Brand.Entity.Location;
import com.Lookup.BrandMicroservice.LocationStock.Entity.ItemStock;
import com.Lookup.BrandMicroservice.LocationStock.Entity.LocationStock;
import com.Lookup.BrandMicroservice.LocationStock.LocationStockDAO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImplementation implements BrandService {
    private final BrandDAO brandDAO;
    private final LocationStockDAO locationStockDAO;

    @Autowired
    public BrandServiceImplementation(BrandDAO brandDAO, LocationStockDAO locationStockDAO)
    {
        this.brandDAO = brandDAO;
        this.locationStockDAO = locationStockDAO;
    }

    @Override
    public List<BrandResponseDTO> getAllBrands() {
        return brandDAO.findAll().stream().map(this::createBrandResponseDTO).toList();
    }

    @Override
    public BrandResponseDTO getBrand(String brandId) {
        Brand brand = brandDAO.findById(new ObjectId(brandId)).orElseThrow(() -> new RuntimeException("Brand does not exist"));

        return createBrandResponseDTO(brand);
    }

    @Override
    public BrandResponseDTO createBrand(BrandCreationDTO brandCreationDTO) {
        Brand brand = Brand.builder()
                .name(brandCreationDTO.getName())
                .nit(brandCreationDTO.getNit())
                .locations(List.of())
                .build();
        brandDAO.save(brand);

        return createBrandResponseDTO(brand);
    }

    @Override
    public void updateBrand(String brandId, BrandCreationDTO brandCreationDTO) {
        Brand brandInDb = brandDAO.findById(new ObjectId(brandId)).orElseThrow(() -> new RuntimeException("Brand does not exist"));
        if (brandCreationDTO.getName() != null)
            brandInDb.setName(brandCreationDTO.getName());

        if (brandCreationDTO.getNit() != null)
            brandInDb.setNit(brandCreationDTO.getNit());

        brandDAO.save(brandInDb);
    }

    @Override
    public void deleteBrand(String brandId) {
        brandDAO.deleteById(new ObjectId(brandId));
    }

    @Override
    public void addLocation(String brandId, LocationCreationDTO locationCreationDTO) {
        Brand brand = brandDAO.findById(new ObjectId(brandId)).orElseThrow(() -> new RuntimeException("Brand does not exist"));

        LocationStock locationStock = LocationStock.builder()
                        .items(new ArrayList<ItemStock>())
                        .build();

        locationStockDAO.save(locationStock);

        brand.getLocations().add(Location.builder()
                .direction(locationCreationDTO.getDirection())
                .local(locationCreationDTO.getLocal())
                .nameOfPlace(locationCreationDTO.getNameOfPlace())
                .city(locationCreationDTO.getCity())
                .state(locationCreationDTO.getState())
                .country(locationCreationDTO.getCountry())
                .latitude(locationCreationDTO.getLatitude())
                .longitude(locationCreationDTO.getLongitude())
                .stock(locationStock)
                .build()
        );

        brandDAO.save(brand);
    }

    private BrandResponseDTO createBrandResponseDTO(Brand brand)
    {
        return BrandResponseDTO.builder()
                .id(brand.getId().toString())
                .name(brand.getName())
                .nit(brand.getNit())
                .locations(
                        brand.getLocations().stream().map(location -> LocationResponseDTO.builder()
                                .direction(location.getDirection())
                                .local(location.getLocal())
                                .nameOfPlace(location.getNameOfPlace())
                                .city(location.getCity())
                                .state(location.getState())
                                .country(location.getCountry())
                                .latitude(location.getLatitude())
                                .longitude(location.getLongitude())
                                .stock(location.getStock())
                                .build()
                        ).toList()
                ).build();
    }
}
