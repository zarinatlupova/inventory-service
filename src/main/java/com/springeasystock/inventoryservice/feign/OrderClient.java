package com.springeasystock.inventoryservice.feign;

import com.springeasystock.inventoryservice.dto.ItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name = "order-service")
public interface OrderClient {

    @GetMapping("/api/orders/items/{itemId}")
    Mono<ItemResponse> getOrderByItemId(@PathVariable Long itemId);
}

