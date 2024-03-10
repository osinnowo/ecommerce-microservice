package com.ecommerce.service.inventory.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventoryDto {
    private Long id;
    private Long stockSold;
    private Boolean isStockAvailable;
    private Long stockTotal;
    private Long stockReserved;
}
