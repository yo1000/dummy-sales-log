package com.yo1000.saleslog.presentation;

import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@ConditionalOnProperty(prefix = "app.monitor", name = "enabled", havingValue = "true", matchIfMissing = false)
@RestController
@RequestMapping("monitor")
public class MonitorRestController {
    private final PointHolderRepository pointHolderRepository;

    public MonitorRestController(PointHolderRepository pointHolderRepository) {
        this.pointHolderRepository = pointHolderRepository;
    }

    @GetMapping
    public Collection<PointHolder> get() {
        return pointHolderRepository.findAll();
    }
}
