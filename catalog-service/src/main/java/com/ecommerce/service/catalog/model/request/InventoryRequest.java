package com.ecommerce.service.catalog.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequest {
    private Long inventoryId;
    private Boolean isStockAvailable;
    private Long stockTotal;
    private Long stockReserved;
    private Long stockSold;
}