package com.ecommerce.service.catalog.service.implementation;

import com.ecommerce.service.catalog.model.common.BaseResponse;
import com.ecommerce.service.catalog.model.dto.InventoryDto;
import com.ecommerce.service.catalog.model.dto.ProductCategoryDto;
import com.ecommerce.service.catalog.model.dto.ProductDto;
import com.ecommerce.service.catalog.model.entity.ProductCategoryEntity;
import com.ecommerce.service.catalog.model.entity.ProductEntity;
import com.ecommerce.service.catalog.model.mapper.ProductMapper;

import com.ecommerce.service.catalog.model.request.InventoryRequest;
import com.ecommerce.service.catalog.model.request.ProductRequest;
import com.ecommerce.service.catalog.proxy.InventoryProxy;
import com.ecommerce.service.catalog.repository.ProductCategoryRepository;
import com.ecommerce.service.catalog.repository.ProductRepository;
import com.ecommerce.service.catalog.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    private final InventoryProxy inventoryProxy;

    @Override
    @Transactional
    public Mono<ProductDto> createProduct(ProductRequest request) {
        ProductCategoryEntity category = productCategoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        ProductEntity entity = ProductMapper.mapFrom(request);
        entity.setCategory(category);
        productRepository.saveAndFlush(entity);

        log.info("Product created: {}", entity.getId());

        InventoryRequest inventoryRequest = InventoryRequest
                .builder()
                .inventoryId(entity.getId())
                .stockReserved(request.getStockReserved())
                .stockSold(request.getStockSold())
                .stockTotal(request.getStockTotal())
                .isStockAvailable(request.getIsStockAvailable())
                .build();

        BaseResponse<InventoryDto> inventoryResponse = inventoryProxy.createInventory(inventoryRequest);

        if (inventoryResponse.getStatus()) {
            log.info("Inventory created for product: {}", entity.getId());
            return Mono.just(ProductMapper.mapFrom(entity));
        } else {
            log.error("Failed to create inventory for product: {}", entity.getId());
            return Mono.error(new RuntimeException("Failed to create inventory"));
        }
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

    @Override
    public Mono<ProductCategoryEntity> getCategoryEntityById(Long categoryId) {
        return Mono.just(productCategoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found")));
    }
}
