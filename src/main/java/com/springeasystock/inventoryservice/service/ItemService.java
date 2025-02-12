package com.springeasystock.inventoryservice.service;

import com.springeasystock.inventoryservice.dto.ItemRequest;
import com.springeasystock.inventoryservice.dto.ItemResponse;
import com.springeasystock.inventoryservice.entity.Item;
import com.springeasystock.inventoryservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Mono<ItemResponse> createItem(ItemRequest request) {
        Item item = new Item(null, request.getName(), request.getDescription(),
                request.getCategory(), request.getSupplier(),
                request.getPrice(), request.getQuantity());

        return itemRepository.save(item)
                .map(savedItem -> new ItemResponse(
                        savedItem.getId(), savedItem.getName(), savedItem.getDescription(),
                        savedItem.getCategory(), savedItem.getSupplier(),
                        savedItem.getPrice(), savedItem.getQuantity()
                ));
    }

    public Flux<ItemResponse> getAllItems() {
        return itemRepository.findAll()
                .map(item -> new ItemResponse(
                        item.getId(), item.getName(), item.getDescription(),
                        item.getCategory(), item.getSupplier(),
                        item.getPrice(), item.getQuantity()
                ));
    }

    public Mono<ItemResponse> getItemById(Long id) {
        return itemRepository.findById(id)
                .map(item -> new ItemResponse(
                        item.getId(), item.getName(), item.getDescription(),
                        item.getCategory(), item.getSupplier(),
                        item.getPrice(), item.getQuantity()
                ));
    }

    public Mono<Void> deleteItem(Long id) {
        return itemRepository.deleteById(id);
    }
}

