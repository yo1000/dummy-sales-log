package com.yo1000.saleslog.domain;

public interface PointHolderRepository {
    PointHolder findByCustomerId(int customerId);
    PointHolder save(PointHolder pointHolder);
}
