package com.yo1000.saleslog.domain;

import java.util.Collection;

public interface PointHolderRepository {
    Collection<PointHolder> findAll();
    PointHolder findByCustomerId(int customerId);
    PointHolder save(PointHolder pointHolder);
}
