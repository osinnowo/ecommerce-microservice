package com.ecommerce.service.inventory.service.implementation;

import com.ecommerce.service.inventory.app.AppItemAlreadyExistException;
import com.ecommerce.service.inventory.model.dto.InventoryDto;
import com.ecommerce.service.inventory.model.dto.InventoryImageDto;
import com.ecommerce.service.inventory.model.entity.InventoryEntity;
import com.ecommerce.service.inventory.model.mapper.InventoryMapper;
import com.ecommerce.service.inventory.model.request.InventoryRequest;
import com.ecommerce.service.inventory.repository.InventoryRepository;
import com.ecommerce.service.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public final class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repository;

    @Override
    public Mono<InventoryDto> createInventory(InventoryRequest request) {

        repository.findById(request.getInventoryId()).ifPresent(inventoryEntity -> {
            throw new AppItemAlreadyExistException("Inventory already exists");
        });

        InventoryEntity entity = InventoryMapper.mapFrom(request);
        repository.saveAndFlush(entity);

        return Mono.just(InventoryMapper.mapFrom(entity));
    }

    @Override
    public Flux<InventoryImageDto> getInventoryImages(Long inventoryId) {
        return null;
    }
}
