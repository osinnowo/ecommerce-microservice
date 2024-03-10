package com.ecommerce.service.catalog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @GetMapping("/greeting")
    public Mono<String> greeting() {
        return Mono.just("Hello, World!");
    }
}
