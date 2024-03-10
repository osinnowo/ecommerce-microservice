package com.ecommerce.service.inventory.model.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventoryRequest {
    private Long inventoryId;
    private Boolean isStockAvailable;
    private Long stockTotal;
    private Long stockReserved;
    private Long stockSold;
}
