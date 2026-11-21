package com.yo1000.saleslog.infrastructure;

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
