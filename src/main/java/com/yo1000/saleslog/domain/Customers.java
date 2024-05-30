package com.yo1000.saleslog.domain;

import java.security.SecureRandom;
import java.util.List;

public enum Customers {
    SQUALL(new Customer(1, "Squall", Gender.MALE), List.of(
                new Factor(100, Items.POTION.data(), 10),
                new Factor(100, Items.HI_POTION.data(), 10),
                new Factor(50, Items.X_POTION.data(), 5),
                new Factor(50, Items.MEGA_POTION.data(), 3),
                new Factor(100, Items.PHOENIX_DOWN.data(), 5),
                new Factor(50, Items.MEGA_PHOENIX.data(), 3),
                new Factor(10, Items.ELIXIR.data(), 2),
                new Factor(50, Items.ANTIDOTE.data(), 3),
                new Factor(50, Items.SOFT.data(), 3),
                new Factor(50, Items.EYE_DROPS.data(), 3),
                new Factor(50, Items.ECHO_SCREEN.data(), 3),
                new Factor(50, Items.HOLY_WATER.data(), 3),
                new Factor(100, Items.REMEDY.data(), 5)
        )),
    ZELL(new Customer(2, "Zell", Gender.MALE), List.of(
            new Factor(200, Items.POTION.data(), 5),
            new Factor(100, Items.HI_POTION.data(), 5),
            new Factor(50, Items.X_POTION.data(), 3),
            new Factor(50, Items.MEGA_POTION.data(), 3),
            new Factor(50, Items.PHOENIX_DOWN.data(), 3),
            new Factor(10, Items.MEGA_PHOENIX.data(), 2),
            new Factor(5, Items.ELIXIR.data(), 1),
            new Factor(10, Items.ANTIDOTE.data(), 1),
            new Factor(10, Items.SOFT.data(), 1),
            new Factor(10, Items.EYE_DROPS.data(), 1),
            new Factor(10, Items.ECHO_SCREEN.data(), 1),
            new Factor(10, Items.HOLY_WATER.data(), 1),
            new Factor(50, Items.REMEDY.data(), 3)
    )),
    IRVINE(new Customer(3, "Irvine", Gender.MALE), List.of(
            new Factor(100, Items.POTION.data(), 5),
            new Factor(100, Items.HI_POTION.data(), 10),
            new Factor(50, Items.X_POTION.data(), 10),
            new Factor(100, Items.MEGA_POTION.data(), 5),
            new Factor(100, Items.PHOENIX_DOWN.data(), 5),
            new Factor(100, Items.MEGA_PHOENIX.data(), 3),
            new Factor(10, Items.ELIXIR.data(), 2),
            new Factor(50, Items.ANTIDOTE.data(), 2),
            new Factor(50, Items.SOFT.data(), 2),
            new Factor(50, Items.EYE_DROPS.data(), 2),
            new Factor(50, Items.ECHO_SCREEN.data(), 2),
            new Factor(50, Items.HOLY_WATER.data(), 2),
            new Factor(100, Items.REMEDY.data(), 5)
    )),
    QUISTIS(new Customer(4, "Quistis", Gender.FEMALE), List.of(
            new Factor(50, Items.POTION.data(), 3),
            new Factor(50, Items.HI_POTION.data(), 5),
            new Factor(50, Items.X_POTION.data(), 5),
            new Factor(100, Items.MEGA_POTION.data(), 10),
            new Factor(100, Items.PHOENIX_DOWN.data(), 5),
            new Factor(50, Items.MEGA_PHOENIX.data(), 3),
            new Factor(50, Items.ELIXIR.data(), 3),
            new Factor(200, Items.ANTIDOTE.data(), 5),
            new Factor(200, Items.SOFT.data(), 5),
            new Factor(200, Items.EYE_DROPS.data(), 5),
            new Factor(200, Items.ECHO_SCREEN.data(), 5),
            new Factor(200, Items.HOLY_WATER.data(), 5),
            new Factor(100, Items.REMEDY.data(), 10)
    )),
    RINOA(new Customer(5, "Rinoa", Gender.FEMALE), List.of(
            new Factor(100, Items.POTION.data(), 10),
            new Factor(100, Items.HI_POTION.data(), 10),
            new Factor(100, Items.X_POTION.data(), 10),
            new Factor(100, Items.MEGA_POTION.data(), 10),
            new Factor(50, Items.PHOENIX_DOWN.data(), 10),
            new Factor(50, Items.MEGA_PHOENIX.data(), 10),
            new Factor(50, Items.ELIXIR.data(), 10),
            new Factor(50, Items.ANTIDOTE.data(), 5),
            new Factor(50, Items.SOFT.data(), 5),
            new Factor(50, Items.EYE_DROPS.data(), 5),
            new Factor(50, Items.ECHO_SCREEN.data(), 5),
            new Factor(50, Items.HOLY_WATER.data(), 5),
            new Factor(100, Items.REMEDY.data(), 10)
    )),
    SELPHIE(new Customer(6, "Selphie", Gender.FEMALE), List.of(
            new Factor(50, Items.POTION.data(), 10),
            new Factor(100, Items.HI_POTION.data(), 10),
            new Factor(100, Items.X_POTION.data(), 5),
            new Factor(50, Items.MEGA_POTION.data(), 5),
            new Factor(50, Items.PHOENIX_DOWN.data(), 5),
            new Factor(50, Items.MEGA_PHOENIX.data(), 5),
            new Factor(50, Items.ELIXIR.data(), 2),
            new Factor(50, Items.ANTIDOTE.data(), 3),
            new Factor(50, Items.SOFT.data(), 3),
            new Factor(50, Items.EYE_DROPS.data(), 3),
            new Factor(50, Items.ECHO_SCREEN.data(), 3),
            new Factor(50, Items.HOLY_WATER.data(), 3),
            new Factor(100, Items.REMEDY.data(), 5)
    )),
    ;

    private final SecureRandom secureRandom = new SecureRandom();

    private Customer data;
    private List<Factor> factors;

    Customers(Customer data, List<Factor> factors) {
        this.data = data;
        this.factors = factors;
    }

    public Customer data() {
        return data;
    }

    public List<SalesItem> buy() {
        return factors.stream()
                .filter(factor -> secureRandom.nextInt(1_000) < factor.permillage())
                .map(factor -> {
                    int quantity = secureRandom.nextInt(factor.maxQuantity()) + 1;
                    return new SalesItem(
                            factor.item().id(),
                            factor.item().name(),
                            factor.item().unitPrice(),
                            quantity
                    );
                }).toList();
    }

    private record Factor(
            int permillage,
            Item item,
            int maxQuantity
    ) {}
}
