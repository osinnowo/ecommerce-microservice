package com.ecommerce.service.catalog.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
}
