package com.microserives.inventory_service.Controller;

import com.microserives.inventory_service.Services.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Boolean> IsinStock(@RequestParam String code, @RequestParam Integer quantity ){
        return new ResponseEntity(inventoryService.checkStock(code, quantity),HttpStatus.CREATED);
    }
}
