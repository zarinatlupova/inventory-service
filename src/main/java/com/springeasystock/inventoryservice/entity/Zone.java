package com.springeasystock.inventoryservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("zone") // Соответствует таблице "zone" в БД
public class Zone {

    @Id
    private Long id;

    @Column("wave_id")
    private Integer waveId; // ID волны обработки

    private String name;
    private String type;

    @Column("item_id")
    private Long itemId; // Ссылка на товар

    @Column("item_count")
    private Integer itemCount; // Количество товара в зоне
}
