package com.ecommerce.service.inventory.controllers;

import com.ecommerce.service.inventory.model.common.BaseResponse;
import com.ecommerce.service.inventory.model.dto.InventoryDto;
import com.ecommerce.service.inventory.model.dto.InventoryImageDto;
import com.ecommerce.service.inventory.model.request.InventoryRequest;
import com.ecommerce.service.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public Mono<ResponseEntity<BaseResponse<InventoryDto>>> createInventory(
            @Validated @RequestBody InventoryRequest request
    ) {
        return inventoryService.createInventory(request)
                .map(BaseResponse::okResponse);
    }

    @GetMapping("/{inventoryId}/images")
    public Mono<ResponseEntity<BaseResponse<List<InventoryImageDto>>>> getInventoryImages(
            @PathVariable Long inventoryId
    ) {
        return inventoryService.getInventoryImages(inventoryId)
                .collectList()
                .map(BaseResponse::okResponse);
    }
}