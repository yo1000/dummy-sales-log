package com.yo1000.saleslog.domain;

public class PointHolder {
    private final Customer customer;
    private int point;
    private final PointBehavior behavior;

    public PointHolder(Customer customer, int point, PointBehavior behavior) {
        this.customer = customer;
        this.point = point;
        this.behavior = behavior;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getPoint() {
        return point;
    }

    public Sales usePoint(Sales plan) {
        Sales sales = behavior.usePoint(plan, point);
        point -= sales.paidPoint();
        point += sales.givenPoint();
        return sales;
    }
}
