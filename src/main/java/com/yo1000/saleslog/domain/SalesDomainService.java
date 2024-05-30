package com.yo1000.saleslog.domain;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SalesDomainService {
    public Sales sell(Customers customer, LocalDateTime dateTime) {
        List<SalesItem> items = customer.buy();
        while (items.isEmpty()) {
            items = customer.buy();
        }

        int total = items.stream().mapToInt(SalesItem::subtotal).sum();

        return new Sales(
                UUID.randomUUID().toString(),
                dateTime,
                0,
                0,
                total,
                items,
                customer.data()
        );
    }
}
