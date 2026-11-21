package com.yo1000.saleslog.config;

import com.yo1000.saleslog.domain.Catalog;
import com.yo1000.saleslog.infrastructure.CsvCatalogLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

@Configuration
@EnableConfigurationProperties({CatalogConfigurationProperties.class, MemberConfigurationProperties.class})
public class CatalogConfig {
    private final Logger logger = LoggerFactory.getLogger(CatalogConfig.class);

    @Bean
    public Catalog catalog(CatalogConfigurationProperties props, ResourceLoader resourceLoader) {
        String location = props.getLocation().endsWith("/")
                ? props.getLocation()
                : props.getLocation() + "/";

        long start = System.currentTimeMillis();
        Catalog catalog = new CsvCatalogLoader().load(
                resourceLoader.getResource(location + "brands.csv"),
                resourceLoader.getResource(location + "genres.csv"),
                resourceLoader.getResource(location + "products.csv"));

        logger.info("Catalog loaded from {}: {} brands, {} products in {} ms",
                location, catalog.brands().size(), catalog.productCount(), System.currentTimeMillis() - start);
        return catalog;
    }
}
