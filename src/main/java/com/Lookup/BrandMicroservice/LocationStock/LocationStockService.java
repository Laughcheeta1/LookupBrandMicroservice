package com.Lookup.BrandMicroservice.LocationStock;

import com.Lookup.BrandMicroservice.LocationStock.DTO.ChangeLocationStockDTO;
import com.Lookup.BrandMicroservice.LocationStock.Entity.ItemStock;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface LocationStockService {
    Map<String, ItemStock> getLocationStock(String locationStockId);

    void addItemStock(String locationStockId, String itemId, ChangeLocationStockDTO changeMade);

    void removeItemStock(String locationStockId, String itemId, ChangeLocationStockDTO changeMade);
}
