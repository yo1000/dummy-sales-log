package com.yo1000.saleslog.domain;

public record Customer(
        int id,
        String name,
        Gender gender
) {}
