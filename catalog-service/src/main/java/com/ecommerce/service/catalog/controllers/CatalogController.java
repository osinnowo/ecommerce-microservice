package com.ecommerce.service.catalog.controllers;

import static com.ecommerce.service.catalog.model.common.BaseResponse.*;
import com.ecommerce.service.catalog.model.common.BaseResponse;
import com.ecommerce.service.catalog.model.dto.ProductCategoryDto;
import com.ecommerce.service.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

//.LazyInitializationException
@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final ProductService productService;
    @GetMapping("/categories")
    public Mono<ResponseEntity<BaseResponse<List<ProductCategoryDto>>>> categories() {
        return productService.getAllCategories(10)
                .collectList()
                .map(item -> okResponse(item));
    }
}
