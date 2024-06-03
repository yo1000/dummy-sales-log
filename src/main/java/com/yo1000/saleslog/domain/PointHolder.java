package com.yo1000.saleslog.domain;

public class PointHolder {
    private final Customer customer;
    private int point;

    public PointHolder(Customer customer, int point) {
        this.customer = customer;
        this.point = point;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getPoint() {
        return point;
    }

    public Sales usePoint(Sales plan, PointBehavior behavior) {
        Sales sales = behavior.usePoint(plan, point);
        point -= sales.paidPoint();
        point += sales.givenPoint();
        return sales;
    }
}
