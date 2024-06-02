package com.yo1000.saleslog.domain;

public class PointHolder {
    private Customer customer;
    private int point;
    private PointBehavior behavior;

    public PointHolder(Customer customer, int point, PointBehavior behavior) {
        this.customer = customer;
        this.point = point;
        this.behavior = behavior;
    }

    public Customer customer() {
        return customer;
    }

    public int point() {
        return point;
    }

    public Sales usePoint(Sales plan) {
        Sales sales = behavior.usePoint(plan, point);
        point -= sales.paidPoint();
        point += sales.givenPoint();
        return sales;
    }
}
