package com.springeasystock.inventoryservice.controller;

import com.springeasystock.inventoryservice.dto.ItemRequest;
import com.springeasystock.inventoryservice.dto.ItemResponse;
import com.springeasystock.inventoryservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ItemResponse> createItem(@RequestBody ItemRequest request) {
        return itemService.createItem(request);
    }

    @GetMapping("/{id}")
    public Mono<ItemResponse> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public Mono<Flux<ItemResponse>> getAllItems() {
        return Mono.just(itemService.getAllItems());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}

