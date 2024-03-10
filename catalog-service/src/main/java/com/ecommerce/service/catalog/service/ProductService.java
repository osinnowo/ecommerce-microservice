package com.ecommerce.service.catalog.service;

import com.ecommerce.service.catalog.model.dto.ProductCategoryDto;
import com.ecommerce.service.catalog.model.dto.ProductDto;
import com.ecommerce.service.catalog.model.entity.ProductCategoryEntity;
import com.ecommerce.service.catalog.model.request.ProductRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductDto> createProduct(ProductRequest productRequest);
    Flux<ProductCategoryDto> getAllCategories(int limit);
    Mono<ProductCategoryEntity> getCategoryEntityById(Long categoryId);
}
