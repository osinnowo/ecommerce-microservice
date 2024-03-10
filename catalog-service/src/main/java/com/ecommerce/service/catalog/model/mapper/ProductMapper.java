package com.ecommerce.service.catalog.model.mapper;

import com.ecommerce.service.catalog.model.dto.ProductCategoryDto;
import com.ecommerce.service.catalog.model.dto.ProductDto;
import com.ecommerce.service.catalog.model.entity.ProductCategoryEntity;
import com.ecommerce.service.catalog.model.entity.ProductEntity;
import com.ecommerce.service.catalog.model.request.ProductRequest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductEntity mapFrom(ProductRequest request) {
        return ProductEntity
                .builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(BigDecimal.valueOf(request.getPrice()))
                .build();
    }

    public static ProductDto mapFrom(ProductEntity entity) {
        return ProductDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice().doubleValue())
                .category(entity.getCategory().getName())
                .build();
    }

    public static ProductCategoryDto mapFrom(ProductCategoryEntity entity) {
        return ProductCategoryDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .products(
                        Optional.ofNullable(entity.getProducts())
                                .map(products -> products
                                        .stream()
                                        .map(ProductMapper::mapFrom)
                                        .collect(Collectors.toList())
                                )
                                .orElse(Collections.emptyList())
                )
                .build();
    }
}
