package com.yo1000.saleslog.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * 会員。購入者の情報は会員IDのみで管理する。
 */
@Entity
public class Customer {
    @Id
    int id;

    public Customer() {}

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
