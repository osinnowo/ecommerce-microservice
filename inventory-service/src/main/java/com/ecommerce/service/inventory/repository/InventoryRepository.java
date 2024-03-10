package com.ecommerce.service.inventory.repository;

import com.ecommerce.service.inventory.model.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> { }
