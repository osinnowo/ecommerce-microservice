package com.ecommerce.service.catalog.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(max = 100, message = "Product name cannot exceed {max} characters")
    @Size(min = 3, message = "Product name must be at least {min} characters")
    private String name;

    @Size(max = 300, message = "Product description cannot exceed {max} characters")
    @Size(min = 10, message = "Product description must be at least {min} characters")
    @NotBlank(message = "Product description is required")
    private String description;

    private Double price;
    private Long categoryId;
    private Long stockTotal;
    private Long stockReserved;
    private Long stockSold;
    private Boolean isStockAvailable;
}
