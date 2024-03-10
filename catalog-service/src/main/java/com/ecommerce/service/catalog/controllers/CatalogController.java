package com.ecommerce.service.catalog.controllers;

import static com.ecommerce.service.catalog.model.common.BaseResponse.*;
import com.ecommerce.service.catalog.configuration.AppConfiguration;
import com.ecommerce.service.catalog.model.common.BaseResponse;
import com.ecommerce.service.catalog.model.dto.ProductCategoryDto;
import com.ecommerce.service.catalog.model.dto.ProductDto;
import com.ecommerce.service.catalog.model.request.ProductRequest;
import com.ecommerce.service.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.util.List;

//.LazyInitializationException
@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final AppConfiguration configuration;
    private final ProductService productService;
    @GetMapping("/categories")
    public Mono<ResponseEntity<BaseResponse<List<ProductCategoryDto>>>> categories() {
        return productService.getAllCategories(10)
                .collectList()
                .map(item -> okResponse(item));
    }

    @GetMapping("/configuration")
    public Mono<ResponseEntity<BaseResponse<AppConfiguration>>> configuration() {
        return Mono.just(okResponse(configuration));
    }

    @PostMapping
    public Mono<ResponseEntity<BaseResponse<ProductDto>>> createProduct(
            @Validated @RequestBody ProductRequest request
    ) {
        return productService.createProduct(request)
                .map(BaseResponse::okResponse);
    }
}
