package com.Lookup.BrandMicroservice.LocationStock;

import com.Lookup.BrandMicroservice.LocationStock.DTO.ChangeLocationStockDTO;
import com.Lookup.BrandMicroservice.LocationStock.Entity.ItemStock;
import com.Lookup.BrandMicroservice.LocationStock.Entity.LocationStock;
import com.Lookup.BrandMicroservice.Size.SizeDAO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LocationStockServiceImplementation implements LocationStockService {
    private final LocationStockDAO locationStockDAO;
    private final SizeDAO sizeDAO;

    @Autowired
    public LocationStockServiceImplementation(LocationStockDAO locationStockDAO, SizeDAO sizeDAO)
    {
        this.locationStockDAO = locationStockDAO;
        this.sizeDAO = sizeDAO;
    }

    @Override
    public Map<String, ItemStock> getLocationStock(String locationStockId) {
        return locationStockDAO.findById(new ObjectId(locationStockId)).orElseThrow(() -> new RuntimeException("Location Stock not found")).getItem();
    }

    @Override
    public void addItemStock(String locationStockId, String itemId, ChangeLocationStockDTO changeMade) {
        LocationStock locationStock = locationStockDAO.findById(new ObjectId(locationStockId)).orElseThrow(() -> new RuntimeException("Location Stock not found"));
        ItemStock itemStock = locationStock.getItem().get(itemId);

        String sizeId = sizeDAO.findByName(changeMade.getSizeName()).orElseThrow(() -> new RuntimeException("Size not found"))
                .getId().toString();

        int stock = itemStock.getSizes().get(sizeId);
        stock += changeMade.getQuantity();
        itemStock.getSizes().put(sizeId, stock);

        locationStockDAO.save(locationStock);
    }

    @Override
    public void removeItemStock(String locationStockId, String itemId, ChangeLocationStockDTO changeMade) {
        LocationStock locationStock = locationStockDAO.findById(new ObjectId(locationStockId)).orElseThrow(() -> new RuntimeException("Location Stock not found"));
        ItemStock itemStock = locationStock.getItem().get(itemId);

        String sizeId = sizeDAO.findByName(changeMade.getSizeName()).orElseThrow(() -> new RuntimeException("Size not found"))
                .getId().toString();

        int stock = itemStock.getSizes().get(sizeId);
        stock -= changeMade.getQuantity();
        itemStock.getSizes().put(sizeId, stock);

        locationStockDAO.save(locationStock);
    }
}
