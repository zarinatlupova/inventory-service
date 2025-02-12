package com.springeasystock.inventoryservice.repository;

import com.springeasystock.inventoryservice.entity.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItemRepository extends ReactiveCrudRepository<Item, Long> {

    // Поиск товаров по названию (может вернуть несколько результатов)
    Flux<Item> findByNameContainingIgnoreCase(String name);

    // Поиск товаров по поставщику
    Flux<Item> findBySupplierIgnoreCase(String supplier);
}

