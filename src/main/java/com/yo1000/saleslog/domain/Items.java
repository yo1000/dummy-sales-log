package com.yo1000.saleslog.domain;

public enum Items {
    POTION(new Item(1, "Potion", 100)),
    HI_POTION(new Item(3, "Hi-Potion", 500)),
    X_POTION(new Item(5, "X-Potion", 5_000)),
    MEGA_POTION(new Item(6, "Mega-Potion", 10_000)),
    PHOENIX_DOWN(new Item(7, "Phoenix Down", 500)),
    MEGA_PHOENIX(new Item(8, "Mega Phoenix", 10_000)),
    ELIXIR(new Item(9, "Elixir", 50_000)),
    ANTIDOTE(new Item(11, "Antidote", 100)),
    SOFT(new Item(12, "Soft", 100)),
    EYE_DROPS(new Item(13, "Eye Drops", 100)),
    ECHO_SCREEN(new Item(14, "Echo Screen", 100)),
    HOLY_WATER(new Item(15, "Holy Water", 100)),
    REMEDY(new Item(16, "Remedy", 1000)),
    ;

    private Item data;

    Items(Item data) {
        this.data = data;
    }

    public Item data() {
        return data;
    }
}
