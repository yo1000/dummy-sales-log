package com.yo1000.saleslog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record Sales(
        String id,
        @JsonFormat(pattern = "uuuu-MM-dd hh:mm:ss")
        LocalDateTime dateTime,
        int discount,
        int paidPoint,
        int paidCash,
        List<SalesItem> items,
        Customer customer
) {
    public Sales {
        if (paidCash() + paidPoint() != total()) {
            throw new IllegalArgumentException("paidCash() and paidPoint() summing is required equals to total()");
        }
    }

    @JsonProperty
    public int total() {
        return Optional.ofNullable(items)
                .orElse(Collections.emptyList()).stream()
                .map(SalesItem::subtotal)
                .reduce(Integer::sum)
                .orElse(0);
    }

    @JsonProperty
    public int givenPoint() {
        return (int) new BigDecimal(paidCash()).multiply(new BigDecimal("0.01")).floatValue();
    }
}
