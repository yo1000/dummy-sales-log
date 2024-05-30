package com.yo1000.saleslog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SalesItem(
        int id,
        String name,
        int unitPrice,
        int quantity
) {
    @JsonProperty
    public int subtotal() {
        return unitPrice() * quantity();
    }
}
