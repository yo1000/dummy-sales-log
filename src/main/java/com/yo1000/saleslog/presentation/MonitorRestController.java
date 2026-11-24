package com.yo1000.saleslog.presentation;

import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@ConditionalOnProperty(prefix = "app.monitor", name = "enabled", havingValue = "true", matchIfMissing = false)
@RestController
@RequestMapping("monitor")
public class MonitorRestController {
    private final PointHolderRepository pointHolderRepository;

    public MonitorRestController(PointHolderRepository pointHolderRepository) {
        this.pointHolderRepository = pointHolderRepository;
    }

    /** すべての会員のポイント残高 */
    @GetMapping
    public Collection<PointHolder> get() {
        return pointHolderRepository.findAll();
    }

    /**
     * 指定した会員のポイント残高（{@code /monitor?customer={id}}）。
     * 一覧と同じ配列形式で返し、まだ購入していない会員の場合は空の配列を返す。
     */
    @GetMapping(params = "customer")
    public Collection<PointHolder> getByCustomer(@RequestParam("customer") int customerId) {
        PointHolder pointHolder = pointHolderRepository.findByCustomerId(customerId);
        return pointHolder != null ? List.of(pointHolder) : List.of();
    }
}
