package com.springeasystock.inventoryservice.service;

import com.springeasystock.inventoryservice.dto.ZoneRequest;
import com.springeasystock.inventoryservice.dto.ZoneResponse;
import com.springeasystock.inventoryservice.entity.Zone;
import com.springeasystock.inventoryservice.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public Mono<ZoneResponse> createZone(ZoneRequest request) {
        Zone zone = new Zone(null, request.getWaveId(), request.getName(),
                request.getType(), request.getItemId(), request.getItemCount());

        return zoneRepository.save(zone)
                .map(savedZone -> new ZoneResponse(
                        savedZone.getId(), savedZone.getWaveId(), savedZone.getName(),
                        savedZone.getType(), savedZone.getItemId(), savedZone.getItemCount()
                ));
    }

    public Flux<ZoneResponse> getAllZones() {
        return zoneRepository.findAll()
                .map(zone -> new ZoneResponse(
                        zone.getId(), zone.getWaveId(), zone.getName(),
                        zone.getType(), zone.getItemId(), zone.getItemCount()
                ));
    }

    public Mono<ZoneResponse> getZoneById(Long id) {
        return zoneRepository.findById(id)
                .map(zone -> new ZoneResponse(
                        zone.getId(), zone.getWaveId(), zone.getName(),
                        zone.getType(), zone.getItemId(), zone.getItemCount()
                ));
    }

    public Flux<ZoneResponse> getZonesByWaveId(Integer waveId) {
        return zoneRepository.findByWaveId(waveId)
                .map(zone -> new ZoneResponse(
                        zone.getId(), zone.getWaveId(), zone.getName(),
                        zone.getType(), zone.getItemId(), zone.getItemCount()
                ));
    }

    public Flux<ZoneResponse> getZonesByItemId(Long itemId) {
        return zoneRepository.findByItemId(itemId)
                .map(zone -> new ZoneResponse(
                        zone.getId(), zone.getWaveId(), zone.getName(),
                        zone.getType(), zone.getItemId(), zone.getItemCount()
                ));
    }

    public Mono<Void> deleteZone(Long id) {
        return zoneRepository.deleteById(id);
    }
}

