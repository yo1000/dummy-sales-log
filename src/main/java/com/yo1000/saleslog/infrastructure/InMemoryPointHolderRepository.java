package com.yo1000.saleslog.infrastructure;

import com.yo1000.saleslog.domain.Customers;
import com.yo1000.saleslog.domain.PointBehaviors;
import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPointHolderRepository implements PointHolderRepository {
    private final Map<Integer, PointHolder> pointHolders;

    public InMemoryPointHolderRepository() {
        pointHolders = new ConcurrentHashMap<>();
        pointHolders.put(Customers.SQUALL.data().id(), new PointHolder(Customers.SQUALL.data(), 0, PointBehaviors.RANDOM.behavior()));
        pointHolders.put(Customers.ZELL.data().id(), new PointHolder(Customers.ZELL.data(), 0, PointBehaviors.NOT_USE.behavior()));
        pointHolders.put(Customers.IRVINE.data().id(), new PointHolder(Customers.IRVINE.data(), 0, PointBehaviors.FRACTIONS_ONLY.behavior()));
        pointHolders.put(Customers.QUISTIS.data().id(), new PointHolder(Customers.QUISTIS.data(), 0, PointBehaviors.FULL_PAYMENT_ONLY.behavior()));
        pointHolders.put(Customers.RINOA.data().id(), new PointHolder(Customers.RINOA.data(), 0, PointBehaviors.EXPENSIVE_PAYMENT_ONLY.behavior()));
        pointHolders.put(Customers.SELPHIE.data().id(), new PointHolder(Customers.SELPHIE.data(), 0, PointBehaviors.FRACTIONS_ONLY.behavior()));
    }

    @Override
    public Collection<PointHolder> findAll() {
        return pointHolders.values();
    }

    @Override
    public PointHolder findByCustomerId(int customerId) {
        return pointHolders.get(customerId);
    }

    @Override
    public PointHolder save(PointHolder pointHolder) {
        return pointHolders.put(pointHolder.getCustomer().id(), pointHolder);
    }
}
