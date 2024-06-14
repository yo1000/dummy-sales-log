package com.yo1000.saleslog.infrastructure;

import com.yo1000.saleslog.domain.Customers;
import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ConditionalOnExpression("{'in-memory','inmemory','memory','mem'}.contains('${app.data.type}')")
@Repository
public class InMemoryPointHolderRepository implements PointHolderRepository {
    private final Map<Integer, PointHolder> pointHolders;

    public InMemoryPointHolderRepository() {
        pointHolders = new ConcurrentHashMap<>();
        pointHolders.put(Customers.SQUALL.data().getId(), new PointHolder(Customers.SQUALL.data(), 0));
        pointHolders.put(Customers.ZELL.data().getId(), new PointHolder(Customers.ZELL.data(), 0));
        pointHolders.put(Customers.IRVINE.data().getId(), new PointHolder(Customers.IRVINE.data(), 0));
        pointHolders.put(Customers.QUISTIS.data().getId(), new PointHolder(Customers.QUISTIS.data(), 0));
        pointHolders.put(Customers.RINOA.data().getId(), new PointHolder(Customers.RINOA.data(), 0));
        pointHolders.put(Customers.SELPHIE.data().getId(), new PointHolder(Customers.SELPHIE.data(), 0));
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
        return pointHolders.put(pointHolder.getCustomer().getId(), pointHolder);
    }
}
