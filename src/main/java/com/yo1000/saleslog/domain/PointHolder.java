package com.yo1000.saleslog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class PointHolder {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    private int point;

    public PointHolder() {}

    public PointHolder(Customer customer, int point) {
        this.customer = customer;
        this.point = point;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Sales usePoint(Sales plan, PointBehavior behavior) {
        Sales sales = behavior.usePoint(plan, point);
        point -= sales.paidPoint();
        point += sales.givenPoint();
        return sales;
    }
}
