package com.ecommerce.service.catalog.service.implementation;

import com.ecommerce.service.catalog.model.dto.ProductCategoryDto;
import com.ecommerce.service.catalog.model.dto.ProductDto;
import com.ecommerce.service.catalog.model.mapper.ProductMapper;
import com.ecommerce.service.catalog.model.request.ProductRequest;
import com.ecommerce.service.catalog.repository.ProductCategoryRepository;
import com.ecommerce.service.catalog.repository.ProductRepository;
import com.ecommerce.service.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public Mono<ProductDto> createProduct(ProductRequest request) {
        return null;
    }

    @Override
    public Flux<ProductCategoryDto> getAllCategories(int limit) {

        if (limit < 1) {
            log.error("Invalid limit value: {}", limit);
            return Flux.error(new IllegalArgumentException("Limit cannot be less than 1"));
        }

        List<ProductCategoryDto> categories = productCategoryRepository
                .findAll()
                .stream()
                .map(ProductMapper::mapFrom)
                .collect(Collectors.toList());

        log.info("Retrieved {} categories", categories.size());

        return Flux.fromIterable(categories);
    }
}
