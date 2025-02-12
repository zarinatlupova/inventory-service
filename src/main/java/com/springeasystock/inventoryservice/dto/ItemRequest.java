package com.springeasystock.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private String name;
    private String description;
    private String category;
    private String supplier;
    private Double price;
    private Integer quantity;
}

