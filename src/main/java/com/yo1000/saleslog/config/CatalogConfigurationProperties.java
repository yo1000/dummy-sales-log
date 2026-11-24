package com.yo1000.saleslog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * カタログ（ブランド・ジャンル・商品）の読込元。
 * {@code location} 配下の brands.csv / genres.csv / products.csv を読み込む。
 */
@ConfigurationProperties(prefix = "app.catalog")
public class CatalogConfigurationProperties {
    private String location = "classpath:data/";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
