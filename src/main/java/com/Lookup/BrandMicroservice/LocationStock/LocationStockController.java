package com.Lookup.BrandMicroservice.LocationStock;

import com.Lookup.BrandMicroservice.LocationStock.DTO.ChangeLocationStockDTO;
import com.Lookup.BrandMicroservice.LocationStock.Entity.ItemStock;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocationStockController {
    ResponseEntity<List<ItemStock>> getLocationStock(String locationStockId);

    ResponseEntity<Void> addItemStock(String locationStockId, String itemId, ChangeLocationStockDTO changeMade);

    ResponseEntity<Void> removeItemStock(String locationStockId, String itemId, ChangeLocationStockDTO changeMade);
}
