package com.springeasystock.inventoryservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("item")
public class Item {

    @Id
    private Long id;

    private String name;
    private String supplier;
    private Float size;
    private Float price;

    private Integer aisle;
    private Integer rack;
    private Integer shelf;
}