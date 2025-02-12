package com.springeasystock.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZoneRequest {
    private Integer waveId;
    private String name;
    private String type;
    private Long itemId;
    private Integer itemCount;
}

