package com.springeasystock.inventoryservice.repository;

import com.springeasystock.inventoryservice.entity.Zone;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ZoneRepository extends ReactiveCrudRepository<Zone, Long> {

    // Получение всех зон, связанных с определенной волной обработки
    Flux<Zone> findByWaveId(Integer waveId);

    // Получение всех зон, содержащих определенный товар
    Flux<Zone> findByItemId(Long itemId);
}

