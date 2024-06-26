package com.yo1000.saleslog.domain;

import java.security.SecureRandom;
import java.util.List;

public enum Customers {
    UNKNOWN(
            null,
            List.of(
                    new BuyingBehavior(100, Items.POTION.data(), 10),
                    new BuyingBehavior(100, Items.HI_POTION.data(), 10),
                    new BuyingBehavior(50, Items.X_POTION.data(), 5),
                    new BuyingBehavior(50, Items.MEGA_POTION.data(), 3),
                    new BuyingBehavior(100, Items.PHOENIX_DOWN.data(), 5),
                    new BuyingBehavior(50, Items.MEGA_PHOENIX.data(), 3),
                    new BuyingBehavior(10, Items.ELIXIR.data(), 2),
                    new BuyingBehavior(50, Items.ANTIDOTE.data(), 3),
                    new BuyingBehavior(50, Items.SOFT.data(), 3),
                    new BuyingBehavior(50, Items.EYE_DROPS.data(), 3),
                    new BuyingBehavior(50, Items.ECHO_SCREEN.data(), 3),
                    new BuyingBehavior(50, Items.HOLY_WATER.data(), 3),
                    new BuyingBehavior(100, Items.REMEDY.data(), 5)
            ),
            PointBehaviors.RANDOM.behavior()),
    SQUALL(
            new Customer(1, "Squall", Gender.MALE),
            List.of(
                    new BuyingBehavior(100, Items.POTION.data(), 10),
                    new BuyingBehavior(100, Items.HI_POTION.data(), 10),
                    new BuyingBehavior(50, Items.X_POTION.data(), 5),
                    new BuyingBehavior(50, Items.MEGA_POTION.data(), 3),
                    new BuyingBehavior(100, Items.PHOENIX_DOWN.data(), 5),
                    new BuyingBehavior(50, Items.MEGA_PHOENIX.data(), 3),
                    new BuyingBehavior(10, Items.ELIXIR.data(), 2),
                    new BuyingBehavior(50, Items.ANTIDOTE.data(), 3),
                    new BuyingBehavior(50, Items.SOFT.data(), 3),
                    new BuyingBehavior(50, Items.EYE_DROPS.data(), 3),
                    new BuyingBehavior(50, Items.ECHO_SCREEN.data(), 3),
                    new BuyingBehavior(50, Items.HOLY_WATER.data(), 3),
                    new BuyingBehavior(100, Items.REMEDY.data(), 5)
            ),
            PointBehaviors.RANDOM.behavior()),
    ZELL(
            new Customer(2, "Zell", Gender.MALE),
            List.of(
                    new BuyingBehavior(200, Items.POTION.data(), 5),
                    new BuyingBehavior(100, Items.HI_POTION.data(), 5),
                    new BuyingBehavior(50, Items.X_POTION.data(), 3),
                    new BuyingBehavior(50, Items.MEGA_POTION.data(), 3),
                    new BuyingBehavior(50, Items.PHOENIX_DOWN.data(), 3),
                    new BuyingBehavior(10, Items.MEGA_PHOENIX.data(), 2),
                    new BuyingBehavior(5, Items.ELIXIR.data(), 1),
                    new BuyingBehavior(10, Items.ANTIDOTE.data(), 1),
                    new BuyingBehavior(10, Items.SOFT.data(), 1),
                    new BuyingBehavior(10, Items.EYE_DROPS.data(), 1),
                    new BuyingBehavior(10, Items.ECHO_SCREEN.data(), 1),
                    new BuyingBehavior(10, Items.HOLY_WATER.data(), 1),
                    new BuyingBehavior(50, Items.REMEDY.data(), 3)
            ),
            PointBehaviors.NOT_USE.behavior()),
    IRVINE(
            new Customer(3, "Irvine", Gender.MALE),
            List.of(
                    new BuyingBehavior(100, Items.POTION.data(), 5),
                    new BuyingBehavior(100, Items.HI_POTION.data(), 10),
                    new BuyingBehavior(50, Items.X_POTION.data(), 10),
                    new BuyingBehavior(100, Items.MEGA_POTION.data(), 5),
                    new BuyingBehavior(100, Items.PHOENIX_DOWN.data(), 5),
                    new BuyingBehavior(100, Items.MEGA_PHOENIX.data(), 3),
                    new BuyingBehavior(10, Items.ELIXIR.data(), 2),
                    new BuyingBehavior(50, Items.ANTIDOTE.data(), 2),
                    new BuyingBehavior(50, Items.SOFT.data(), 2),
                    new BuyingBehavior(50, Items.EYE_DROPS.data(), 2),
                    new BuyingBehavior(50, Items.ECHO_SCREEN.data(), 2),
                    new BuyingBehavior(50, Items.HOLY_WATER.data(), 2),
                    new BuyingBehavior(100, Items.REMEDY.data(), 5)
            ),
            PointBehaviors.FRACTIONS_ONLY.behavior()),
    QUISTIS(
            new Customer(4, "Quistis", Gender.FEMALE),
            List.of(
                    new BuyingBehavior(50, Items.POTION.data(), 3),
                    new BuyingBehavior(50, Items.HI_POTION.data(), 5),
                    new BuyingBehavior(50, Items.X_POTION.data(), 5),
                    new BuyingBehavior(100, Items.MEGA_POTION.data(), 10),
                    new BuyingBehavior(100, Items.PHOENIX_DOWN.data(), 5),
                    new BuyingBehavior(50, Items.MEGA_PHOENIX.data(), 3),
                    new BuyingBehavior(50, Items.ELIXIR.data(), 3),
                    new BuyingBehavior(200, Items.ANTIDOTE.data(), 5),
                    new BuyingBehavior(200, Items.SOFT.data(), 5),
                    new BuyingBehavior(200, Items.EYE_DROPS.data(), 5),
                    new BuyingBehavior(200, Items.ECHO_SCREEN.data(), 5),
                    new BuyingBehavior(200, Items.HOLY_WATER.data(), 5),
                    new BuyingBehavior(100, Items.REMEDY.data(), 10)
            ),
            PointBehaviors.FULL_PAYMENT_ONLY.behavior()),
    RINOA(
            new Customer(5, "Rinoa", Gender.FEMALE),
            List.of(
                    new BuyingBehavior(100, Items.POTION.data(), 10),
                    new BuyingBehavior(100, Items.HI_POTION.data(), 10),
                    new BuyingBehavior(100, Items.X_POTION.data(), 10),
                    new BuyingBehavior(100, Items.MEGA_POTION.data(), 10),
                    new BuyingBehavior(50, Items.PHOENIX_DOWN.data(), 10),
                    new BuyingBehavior(50, Items.MEGA_PHOENIX.data(), 10),
                    new BuyingBehavior(50, Items.ELIXIR.data(), 10),
                    new BuyingBehavior(50, Items.ANTIDOTE.data(), 5),
                    new BuyingBehavior(50, Items.SOFT.data(), 5),
                    new BuyingBehavior(50, Items.EYE_DROPS.data(), 5),
                    new BuyingBehavior(50, Items.ECHO_SCREEN.data(), 5),
                    new BuyingBehavior(50, Items.HOLY_WATER.data(), 5),
                    new BuyingBehavior(100, Items.REMEDY.data(), 10)
            ),
            PointBehaviors.EXPENSIVE_PAYMENT_ONLY.behavior()),
    SELPHIE(
            new Customer(6, "Selphie", Gender.FEMALE),
            List.of(
                    new BuyingBehavior(50, Items.POTION.data(), 10),
                    new BuyingBehavior(100, Items.HI_POTION.data(), 10),
                    new BuyingBehavior(100, Items.X_POTION.data(), 5),
                    new BuyingBehavior(50, Items.MEGA_POTION.data(), 5),
                    new BuyingBehavior(50, Items.PHOENIX_DOWN.data(), 5),
                    new BuyingBehavior(50, Items.MEGA_PHOENIX.data(), 5),
                    new BuyingBehavior(50, Items.ELIXIR.data(), 2),
                    new BuyingBehavior(50, Items.ANTIDOTE.data(), 3),
                    new BuyingBehavior(50, Items.SOFT.data(), 3),
                    new BuyingBehavior(50, Items.EYE_DROPS.data(), 3),
                    new BuyingBehavior(50, Items.ECHO_SCREEN.data(), 3),
                    new BuyingBehavior(50, Items.HOLY_WATER.data(), 3),
                    new BuyingBehavior(100, Items.REMEDY.data(), 5)
            ),
            PointBehaviors.FRACTIONS_ONLY.behavior()),
    ;

    private final SecureRandom secureRandom = new SecureRandom();

    private final Customer data;
    private final List<BuyingBehavior> buyingBehaviors;
    private final PointBehavior pointBehavior;

    Customers(Customer data, List<BuyingBehavior> buyingBehaviors, PointBehavior pointBehavior) {
        this.data = data;
        this.buyingBehaviors = buyingBehaviors;
        this.pointBehavior = pointBehavior;
    }

    public Customer data() {
        return data;
    }

    public List<SalesItem> buy() {
        return buyingBehaviors.stream()
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

    public PointBehavior getPointBehavior() {
        return pointBehavior;
    }
}
