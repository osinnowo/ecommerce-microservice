package com.ecommerce.service.catalog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private Long id;
    private Long stockSold;
    private Boolean isStockAvailable;
    private Long stockTotal;
    private Long stockReserved;
}
