package com.ecommerce.service.inventory.service;

import com.ecommerce.service.inventory.model.dto.InventoryDto;
import com.ecommerce.service.inventory.model.dto.InventoryImageDto;
import com.ecommerce.service.inventory.model.request.InventoryRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryService {
    Mono<InventoryDto> createInventory(InventoryRequest request);
    Flux<InventoryImageDto> getInventoryImages(Long inventoryId);
}
