package com.microserives.inventory_service.Repository;



import com.microserives.inventory_service.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    List<Inventory> findByCodeIn(List<String> skuCode);


    boolean existsByCodeAndQuantityIsGreaterThanEqual(String code, Integer quantity);
}