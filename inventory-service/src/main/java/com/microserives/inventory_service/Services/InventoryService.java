package com.microserives.inventory_service.Services;


import com.microserives.inventory_service.Repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public boolean checkStock(String code, Integer quantity) {
        return inventoryRepository.existsByCodeAndQuantityIsGreaterThanEqual(code, quantity);
    }
}
