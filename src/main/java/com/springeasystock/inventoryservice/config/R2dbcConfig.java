package com.springeasystock.inventoryservice.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class R2dbcConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get("r2dbc:postgresql://localhost:2910/inventory_db");
    }
}
