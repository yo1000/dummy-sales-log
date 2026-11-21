package com.yo1000.saleslog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SalesItem(
        int id,
        String name,
        String color,
        Brand brand,
        Genre genre,
        int unitPrice,
        int quantity
) {
    public static SalesItem of(Product product, Brand brand, Genre genre, int quantity) {
        return new SalesItem(
                product.id(),
                product.name(),
                product.color(),
                brand,
                genre,
                product.price(),
                quantity);
    }

    @JsonProperty
    public int subtotal() {
        return unitPrice() * quantity();
    }
}
