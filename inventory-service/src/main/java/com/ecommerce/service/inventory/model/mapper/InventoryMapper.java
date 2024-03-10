package com.ecommerce.service.inventory.model.mapper;

import com.ecommerce.service.inventory.model.dto.InventoryDto;
import com.ecommerce.service.inventory.model.entity.InventoryEntity;
import com.ecommerce.service.inventory.model.request.InventoryRequest;

public class InventoryMapper {
    public static InventoryEntity mapFrom(InventoryRequest request) {
        return InventoryEntity
                .builder()
                .id(request.getInventoryId())
                .stockSold(request.getStockSold())
                .isStockAvailable(request.getIsStockAvailable())
                .stockTotal(request.getStockTotal())
                .stockReserved(request.getStockReserved())
                .build();
    }

    public static InventoryDto mapFrom(InventoryEntity entity) {
        return InventoryDto
                .builder()
                .id(entity.getId())
                .stockSold(entity.getStockSold())
                .isStockAvailable(entity.getIsStockAvailable())
                .stockTotal(entity.getStockTotal())
                .stockReserved(entity.getStockReserved())
                .build();
    }
}
