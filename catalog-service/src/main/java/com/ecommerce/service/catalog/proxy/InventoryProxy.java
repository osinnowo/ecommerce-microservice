package com.ecommerce.service.catalog.proxy;

import com.ecommerce.service.catalog.model.common.BaseResponse;
import com.ecommerce.service.catalog.model.dto.InventoryDto;
import com.ecommerce.service.catalog.model.request.InventoryRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service", url = "http://localhost:8201")
public interface InventoryProxy {
    @PostMapping(
        value = "/inventory",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    BaseResponse<InventoryDto> createInventory(@RequestBody InventoryRequest request);
}
