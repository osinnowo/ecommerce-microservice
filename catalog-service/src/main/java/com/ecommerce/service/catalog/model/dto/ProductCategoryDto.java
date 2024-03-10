package com.ecommerce.service.catalog.model.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ProductCategoryDto {
    private Long id;
    private String name;
    private String description;
    private List<ProductDto> products;
}
