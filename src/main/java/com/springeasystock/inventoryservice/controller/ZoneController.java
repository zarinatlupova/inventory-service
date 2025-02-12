package com.springeasystock.inventoryservice.controller;

import com.springeasystock.inventoryservice.dto.ZoneRequest;
import com.springeasystock.inventoryservice.dto.ZoneResponse;
import com.springeasystock.inventoryservice.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/zones")
@RequiredArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ZoneResponse> createZone(@RequestBody ZoneRequest request) {
        return zoneService.createZone(request);
    }

    @GetMapping("/{id}")
    public Mono<ZoneResponse> getZoneById(@PathVariable Long id) {
        return zoneService.getZoneById(id);
    }

    @GetMapping
    public Mono<Flux<ZoneResponse>> getAllZones() {
        return Mono.just(zoneService.getAllZones());
    }

    @GetMapping("/wave/{waveId}")
    public Mono<Flux<ZoneResponse>> getZonesByWaveId(@PathVariable Integer waveId) {
        return Mono.just(zoneService.getZonesByWaveId(waveId));
    }

    @GetMapping("/item/{itemId}")
    public Mono<Flux<ZoneResponse>> getZonesByItemId(@PathVariable Long itemId) {
        return Mono.just(zoneService.getZonesByItemId(itemId));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteZone(@PathVariable Long id) {
        return zoneService.deleteZone(id);
    }
}

