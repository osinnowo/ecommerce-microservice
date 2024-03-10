package com.ecommerce.service.catalog.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("catalog-service")
public class AppConfiguration {
    private int minimum;
    private int maximum;
}
